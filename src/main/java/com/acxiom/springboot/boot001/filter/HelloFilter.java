package com.acxiom.springboot.boot001.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class HelloFilter {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    //2、先自定义Filter 必须实现三个接口方法
    public class MyFilter implements Filter{
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

            System.out.println("MyFilter is initing...");
        }

        @Override
        public void destroy() {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            //装载成httpservletRequest.处理页面
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("myFilter is working.." + request.getRequestURI()+ "IP:" + request.getRequestURL());
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
