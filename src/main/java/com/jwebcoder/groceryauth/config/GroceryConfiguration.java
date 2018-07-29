package com.jwebcoder.groceryauth.config;

import com.jwebcoder.groceryauth.common.interceptor.GroceryCoreInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletRequestListener;

/**
 * Created by Jason on 14/10/2017.
 */

@Configuration
public class GroceryConfiguration implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(GroceryConfiguration.class);

    @Autowired
    private GroceryCoreInterceptor groceryCoreInterceptor;

    @Autowired
    private CustomProperty customProperty;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(groceryCoreInterceptor);
    }

    @Bean
    public ServletRequestListener createServletRequestListener() {
        return new RequestContextListener();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

   /* @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50 * 1024 * 1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }*/


}
