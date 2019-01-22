package com.szr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *SpringBoot整合Filter 方式一
 *<filter>
 *	<filter-name>FirstFilter</filter-name>
 *	<filter-class>com.bjsxt.filter.FirstFilter</filter-class>
 *</filter>
 *<filter-mapping>
 *	<filter-name>FirstFilter</filter-name>
 *	<url-pattern>/first</url-pattern>
 *</filter-mapping>
 */
//@WebFilter(filterName = "FirstFilter", urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {

    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        System.out.println("初始化Filter");
    }

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        System.out.println("进入Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开Filter");
    }

    @Override
    public void destroy (){
        System.out.println("销毁Filter");
    }
}
