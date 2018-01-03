package com.imooc.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Sonic on 2017/9/30.
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getComplateOrder())) {

                    String orderNumber = mockQueue.getComplateOrder();
                    logger.info("返回订单处理结果：" + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    mockQueue.setComplateOrder(null);

                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
