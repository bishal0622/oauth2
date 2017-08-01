package com.oauthdemo.example.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
@ComponentScan(basePackages = "com.oauthdemo.example")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String RESOURCE_ID = "my_rest_api";

    @Autowired
    DefaultTokenServices defaultTokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID).stateless(false);
        resources.tokenServices(defaultTokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/check").access("hasRole('admin')")
                .antMatchers(HttpMethod.GET,"/user").access("hasRole('admin')")
                .antMatchers(HttpMethod.POST,"/user").permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/user/").permitAll()
//                .antMatchers(HttpMethod.OPTIONS,"/user").permitAll()
//                .antMatchers(HttpMethod.POST,"/user/").permitAll()
//                .antMatchers(HttpMethod.GET, "/user/").hasRole("admin")
////                .antMatchers(HttpMethod.DELETE, "/user/").access("hasRole('admin')")
////                .antMatchers(HttpMethod.OPTIONS,"/user/activate/**").access("hasRole('admin')")
//                .antMatchers(HttpMethod.PUT, "/user/activate/**").access("hasRole('admin')")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
