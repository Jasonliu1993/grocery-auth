package com.jwebcoder.groceryauth.config;

import com.jwebcoder.groceryauth.common.service.GroceryUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GrocerSecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("irving")
                .password(passwordEncoder().encode("123456"))
                .roles("read");
        // auth.userDetailsService(userDetailsService())
        //   .passwordEncoder(passwordEncoder());
    }

    //    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .requestMatchers()
//                .antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();


//        http.requestMatchers()
//                .antMatchers("/login", "/oauth/authorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll();

        //     http.csrf().disable();
        //不拦截 oauth 开放的资源
        http.requestMatchers()
                .anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
