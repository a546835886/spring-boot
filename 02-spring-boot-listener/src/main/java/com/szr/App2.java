package com.szr;

import com.szr.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot整合Listener方式二
 *
 *
 */
@SpringBootApplication
public class App2 {
    public static void main (String[] args){
        SpringApplication.run(App2.class,args);
    }

    /**
     * 注册listener
     */
    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean  = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }

}
