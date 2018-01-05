package com.imooc.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by Sonic on 2018/1/3.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private SecurityProperties securityProperties;

//    @Autowired
//    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
//            .loginPage("/imooc-signIn2.html")
//            .loginProcessingUrl("/authentication/form")

            .loginPage("/authentication/require")
            .loginProcessingUrl("/authentication/form")
//            .successHandler("imoocAuthenticationSuccessHandler")
//        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/imooc-signIn2.html").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();


    }
}
