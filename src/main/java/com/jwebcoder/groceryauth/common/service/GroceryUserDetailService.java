package com.jwebcoder.groceryauth.common.service;

import com.jwebcoder.groceryauth.common.constants.GroceryConsts;
import com.jwebcoder.groceryauth.common.entity.SystemUser;
import com.jwebcoder.groceryauth.common.repository.SystemUserRepository;
import com.jwebcoder.groceryauth.common.utils.JacksonTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("groceryUserDetailService")
public class GroceryUserDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(GroceryUserDetailService.class);

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SystemUser userName = systemUserRepository.findByUserName(username);
        logger.info("GroceryUserDetailService/loadUserByUsername/userName{}", JacksonTools.writteObjectToValue(userName));
        if (Objects.nonNull(userName)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if (GroceryConsts.ROLE_ADMIN.equals(userName.getType())) {
                grantedAuthorities.add(new SimpleGrantedAuthority(GroceryConsts.ROLE_ADMIN));
            }
            grantedAuthorities.add(new SimpleGrantedAuthority(GroceryConsts.ROLE_CUSTOM));
            return new User(userName.getUserName(), userName.getPassword(), grantedAuthorities);
        }
        return null;

    }
}
