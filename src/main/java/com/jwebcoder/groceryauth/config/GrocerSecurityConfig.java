package com.jwebcoder.groceryauth.config;

import com.jwebcoder.groceryauth.common.service.GroceryUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GrocerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("groceryUserDetailService")
    private GroceryUserDetailService groceryUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        http.authorizeRequests()
        //            .antMatchers("/", "/index.html", "/oauth/**").permitAll() //允许访问
        //            .anyRequest().authenticated() //其他地址的访问需要验证权限
        //            .and()
        //            .formLogin()
        //            .loginPage("/login.html") //登录页
        //            .failureUrl("/login-error.html").permitAll()
        //            .and()
        //            .logout()
        //            .logoutSuccessUrl("/index.html");
        http.authorizeRequests().anyRequest().fullyAuthenticated();
//        http.formLogin().loginPage("/login").failureUrl("/login?code=").permitAll();
        http.formLogin().permitAll();
        http.logout().permitAll();
        http.authorizeRequests().antMatchers("/oauth/authorize").permitAll();

    }

    /**
     * 用户验证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(groceryUserDetailService).passwordEncoder(passwordEncoder);
    }

    /**
     * Spring Boot 2 配置，这里要bean 注入
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    /**
     * 密码加密方法
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
