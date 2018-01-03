package com.imock.security.browser;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Sonic on 2018/1/3.
 */
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
//        http.httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();

    }
}
