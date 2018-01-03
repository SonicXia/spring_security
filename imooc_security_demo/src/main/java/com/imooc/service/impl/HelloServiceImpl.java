package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by Sonic on 2017/9/29.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }
}
