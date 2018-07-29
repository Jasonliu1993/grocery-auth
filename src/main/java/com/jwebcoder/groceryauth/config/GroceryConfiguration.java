package com.jwebcoder.groceryauth.config;

import com.jwebcoder.groceryauth.common.interceptor.GroceryCoreInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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

}
