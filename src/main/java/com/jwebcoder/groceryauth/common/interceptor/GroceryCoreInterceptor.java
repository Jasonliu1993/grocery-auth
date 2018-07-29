package com.jwebcoder.groceryauth.common.interceptor;

import com.jwebcoder.groceryauth.config.CustomProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
public class GroceryCoreInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

}
