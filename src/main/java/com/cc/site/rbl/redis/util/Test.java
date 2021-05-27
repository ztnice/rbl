package com.cc.site.rbl.redis.util;

public class Test {

    public static void main(String[] args) {

        String s = JedisUtil.set("test","111");
        System.out.println(s);

        System.out.println(JedisUtil.get("test"));
        JedisUtil.set("test_1","111");
        JedisUtil.set("test_2","111");
        JedisUtil.set("test_3","111");

        System.out.println(JedisUtil.hvals("test_1"));


    }
}
