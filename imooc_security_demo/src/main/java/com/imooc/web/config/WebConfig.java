package com.imooc.web.config;

import com.imooc.web.interceptor.TimeIntercetpor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sonic on 2017/9/29.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeIntercetpor timeIntercetpor;

    /**
     * 注册拦截器（同步）
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeIntercetpor);
    }


}
