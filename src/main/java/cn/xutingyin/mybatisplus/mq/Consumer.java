package cn.xutingyin.mybatisplus.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @Description: 消费者
* @Author: xuty
* @Date: 2019/10/17 14:33
*/

@Component
public class Consumer {
    Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * queuesToDeclare 这种方式会自动创建队列
     * queues          这种方式需要到RabbitMQ WebUI 界面去手动创建名字为 message 的队列
     * @param message  传递的消息
     */
    @RabbitListener(queues={"message"})
    @RabbitListener(queuesToDeclare =@Queue("message"))
    @RabbitHandler
    public void process(String message) {
        try {
            System.out.println("Cosumer -1："+ message);
        } catch (Exception e) {
           logger.error("Consumer.process()方法出现异常,",e);
        }
    }
}
