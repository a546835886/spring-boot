package com.szr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * spring-boot 整合Filter方式一
 */
@SpringBootApplication
@ServletComponentScan
public class App {
    public static void main (String[] args){
        SpringApplication.run(App.class, args);
    }
}
