package com.fbj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import until.MD5Utils;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {


        System.out.println(  MD5Utils.code("123"));
    }

}
