package com.kangkang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.kangkang.mapper")
//@EnableSwagger2
@EnableWebMvc
public class AgriculturalProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgriculturalProductsApplication.class, args);
    }

}
