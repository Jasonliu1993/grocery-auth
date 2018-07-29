package com.jwebcoder.groceryauth.interceptor;

import com.jwebcoder.groceryauth.config.CustomProperty;
import com.jwebcoder.groceryauth.entity.SystemUser;
import com.jwebcoder.groceryauth.utils.JacksonTools;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        //oauth2的认证直接通过
        if (request.getRequestURI().contains("/oauth2")) {
            return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isNotEmpty(token)) {
            HttpSession session = request.getSession();
            SystemUser systemUser = JacksonTools.readValueForObject(redisTemplate.opsForValue().get(token), SystemUser.class);
            if (request.getRequestURI().contains("/admin")) {
                if (systemUser != null) {
                    if ("admin".equals(systemUser.getType())) {
                        return true;
                    } else {
                        response.sendRedirect(request.getContextPath() + "/error/authFailed");
                        return false;
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + "/error/authFailed");
                    return false;
                }
            } else {
                List<String> notAllowUrl = customProperty.getLoginOnly();

                for (String URL : notAllowUrl) {
                    if (request.getRequestURI().contains(URL)) {
                        if (systemUser != null)
                            return true;
                        else {

                            response.sendRedirect(request.getContextPath() + "/error/authFailed");
                            return false;
                        }
                    }

                }
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

}
