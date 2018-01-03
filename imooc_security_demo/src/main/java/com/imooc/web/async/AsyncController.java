package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by Sonic on 2017/9/30.
 */
@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")

    /**
     * 同步处理
     */
//    public String order() throws Exception {
//        logger.info("主线程开始");
//        Thread.sleep(1000);
//        logger.info("主线程返回");
//        return "success";
//    }

    /**
     * 使用Callable异步处理Rest服务
     */
//    public Callable<String> order() {
//        logger.info("主线程开始");
//        Callable<String> result = new Callable<String>() {
//
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始");
//                Thread.sleep(1000);
//                logger.info("副线程结束");
//                return "success";
//            }
//        };
//        logger.info("主线程结束");
//        return result;
//    }

    /**
     * 使用DeferredResult异步处理Rest服务（监听消息队列）
     */
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);

        logger.info("主线程返回");
        return result;

    }



}
