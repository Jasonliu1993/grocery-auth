package com.jwebcoder.groceryauth.config;

import com.jwebcoder.groceryauth.common.service.MyRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class GroceryAuthenticationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    //本系统获得dataSource的方式
    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory connectionFactory;


    @Autowired
    @Qualifier("groceryUserDetailService")
    private UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");
//        return new MyBCryptPasswordEncoder();
    }

    @Bean
    public MyRedisTokenStore tokenStore() {
        return new MyRedisTokenStore(connectionFactory);
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    public ApprovalStore approvalStore() {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore());
        return store;
    }

    /*
    @Bean
    public UserApprovalHandler userApprovalHandler() throws Exception {
        MyUserApprovalHandler handler = new MyUserApprovalHandler();
        handler.setApprovalStore(approvalStore());
        handler.setClientDetailsService(clientDetailsService);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(
                clientDetailsService));
        handler.setUseApprovalStore(true);
        return handler;
    }
    */

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//         //客户端信息通过Redis去取得验证
//        final RedisClientDetailsServiceBuilder builder = new RedisClientDetailsServiceBuilder();
//        clients.setBuilder(builder);
        //通过JDBC去查询数据库oauth_client_details表验证clientId信息
        clients.jdbc(this.dataSource).clients(this.clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(this.tokenStore())
                 .userDetailsService(userDetailsService)
                // .userApprovalHandler(userApprovalHandler())
                .authorizationCodeServices(this.authorizationCodeServices());

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
}

