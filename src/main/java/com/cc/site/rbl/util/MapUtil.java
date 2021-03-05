package com.cc.site.rbl.util;

import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapUtil {

    public static final String BLANK_FIELD = "";
    public static <T> Map<String, String> beanToMap(T obj) {

        Map<String, String> map = new HashMap<>();
        if (obj == null)
            return map;

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod(); // 得到property对应的getter方法
                    String value = getter.invoke(obj)+"";
                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return map;

    }



    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {

        T obj = null;

        try {
            obj = clazz.newInstance();
        } catch (Exception var11) {
            throw new RuntimeException(var11.getMessage(), var11);
        }

        Map<String, Field> allFields = getAllFields(clazz);

        Field field;
        for(Iterator var5 = allFields.values().iterator(); var5.hasNext(); field.setAccessible(false)) {
            field = (Field)var5.next();
            String fieldname = field.getName();
            Object fieldval = map.get(fieldname);
            field.setAccessible(true);
            if(fieldval != null) {
                try {
                    field.set(obj, fieldval);
                } catch (IllegalAccessException var10) {
                    throw new RuntimeException(var10.getMessage(), var10);
                }
            }
        }

        return obj;
    }


    private static Map<String, Field> getAllFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        HashMap<String, Field> allFields = new HashMap();

        while(true) {
            Field[] clazzFields;
            int var5;
            do {
                if(clazz.getSuperclass().equals(Object.class)) {
                    Field[] var10 = fields;
                    var5 = fields.length;

                    for(int var9 = 0; var9 < var5; ++var9) {
                        Field fed = var10[var9];
                        allFields.put(fed.getName(), fed);
                    }

                    return allFields;
                }

                clazz = clazz.getSuperclass();
                clazzFields = clazz.getDeclaredFields();
            } while(clazzFields.length <= 0);

            Field[] var7 = clazzFields;
            int var6 = clazzFields.length;

            for(var5 = 0; var5 < var6; ++var5) {
                Field fd = var7[var5];
                allFields.put(fd.getName(), fd);
            }
        }
    }

}
