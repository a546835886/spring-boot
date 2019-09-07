package com.szr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <一句话功能描述>
 * <功能详细描述>
 *
 * @author wzh
 * @version 2018-06-24 20:20
 * @see [相关类/方法] (可选)
 **/

/**
 * SpringBoot 测试类
 *
 * @RunWith:启动器 SpringJUnit4ClassRunner.class：让 junit 与 spring 环境进行整合
 * @SpringBootTest(classes={App.class}) 1, 当前类为 springBoot 的测试类
 * @SpringBootTest(classes={App.class}) 2, 加载 SpringBoot 启动类。启动springBoot
 * junit 与 spring 整合@Contextconfiguartion("classpath:applicationContext.xml")
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class PropertiesTest{

    @Autowired
    PropertiesTestBean propertiesTestBean;

    @Test
    public void test()
    {
        System.out.println(propertiesTestBean.toString());
    }

}
