package com.szr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <注解读取配置文件测试类>
 * <功能详细描述>
 * @author wzh
 * @version 2018-06-30 18:55
 * @see [相关类/方法] (可选)
 **/
@Component
@PropertySource(value = "classpath:static/file/test.properties",encoding = "utf-8")
public class PropertiesTestBean {

    //在application.properties中的文件，直接使用@Value读取即可，applicarion的读取优先级最高

    @Value("${test.name}")
    private String name;

    @Value("${test.sex}")
    private String sex;

    @Value("${test.age}")
    private Long age;

    //省略get set toString方法..........

    @Override
    public String toString() {
        return "PropertiesTestBean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}