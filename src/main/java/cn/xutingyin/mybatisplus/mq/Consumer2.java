package cn.xutingyin.mybatisplus.mq;

import cn.xutingyin.mybatisplus.entity.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
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
public class Consumer2 {
    Logger logger = LoggerFactory.getLogger(Consumer2.class);

    @RabbitListener(queuesToDeclare =@Queue("message"))
    @RabbitHandler
    public void process(String message) {
        System.out.println("Cosumer -2："+ message);
    }
}
