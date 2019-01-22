package com.szr;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szr.mapper")
public class App {
    public static void main (String[] args){
        SpringApplication.run(App.class,args);
    }
}
