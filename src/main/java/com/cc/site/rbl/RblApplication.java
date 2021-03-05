package com.cc.site.rbl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cc.site.rbl.mapper")
public class RblApplication {

    public static void main(String[] args) {
        SpringApplication.run(RblApplication.class, args);
    }

}
