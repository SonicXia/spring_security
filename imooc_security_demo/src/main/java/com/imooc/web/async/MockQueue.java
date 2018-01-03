package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sonic on 2017/9/30.
 */
@Component
public class MockQueue {

    private String placeOrder;

    private String complateOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws Exception {
//        System.out.println("接到下单请求，" + placeOrder);
//        Thread.sleep(1000);
//        this.complateOrder = placeOrder;
//        System.out.println("下单请求处理完毕：" + placeOrder);

        new Thread(() -> {
            logger.info("接到下单请求，" + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.complateOrder = placeOrder;
            logger.info("下单请求处理完毕：" + placeOrder);
        }).start();

    }

    public String getComplateOrder() {
        return complateOrder;
    }

    public void setComplateOrder(String complateOrder) {
        this.complateOrder = complateOrder;
    }
}
