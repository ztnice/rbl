package com.cc.site.rbl.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2021/3/8
 */
public class MapUtil {


    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz){
        if (map == null) {
            return null;
        }
        try {
            T obj = clazz.newInstance();
            BeanUtils.populate(obj, map);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public static <T> Map<?,?> objectToMap(T obj) throws Exception{
        if (obj == null) {
            return null;
        }
        return new org.apache.commons.beanutils.BeanMap(obj);
    }



    public static <T> Map<String,Object> object2Map(T obj) throws Exception{
        if (obj == null) {
            return null;
        }

        Map<String,Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
            map.put(field.getName(),field.get(obj));
        }
        return map;
    }


}
