package cn.xutingyin.mybatisplus.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @Description: 消费者
* @Author: xuty
* @Date: 2019/10/17 14:33
*/

@Component
@RabbitListener(queues = "message")
public class Consumer {
    Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void process(String Str) {
        logger.info("接收消息："+Str);
        logger.info("接收消息时间："+new Date());
    }
}
