package com.jwebcoder.groceryauth.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

//@Service
public class GroceryCodeAuthService extends RandomValueAuthorizationCodeServices {

    @Autowired
    private RedisTemplate<String, OAuth2Authentication> redisTemplate;

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        redisTemplate.opsForValue().set(code, authentication, 10, TimeUnit.MINUTES);
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        OAuth2Authentication auth2Authentication = redisTemplate.opsForValue().get(code);
        if (!Objects.isNull(auth2Authentication)) {
            redisTemplate.delete(code);
        }
        return auth2Authentication;
    }
}
