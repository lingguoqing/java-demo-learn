package com.ling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ling.mapper")
public class SpringBootSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSystemApplication.class, args);
    }

}
