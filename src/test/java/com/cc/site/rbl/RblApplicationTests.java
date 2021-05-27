package com.cc.site.rbl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RblApplicationTests {

    @Test
    void contextLoads() {


        Integer i1 = -1;
        Integer i2 = -1;

        Integer i3 = 130;
        Integer i4 = 130;

        System.out.println(i1 == i2 );
        System.out.println(i3 == i4);
    }





}
