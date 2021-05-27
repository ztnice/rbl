package com.cc.site.rbl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.cc.site.rbl.mapper")
//@EnableCanalClient
//开启缓存
@EnableCaching
public class RblApplication {

    public static void main(String[] args) {
        SpringApplication.run(RblApplication.class, args);
    }

}
