package cn.xutingyin.mybatisplus.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/** 
* @Description: topic 消费者
* @Author: xuty 
* @Date: 2019/10/22 9:45
*/
@Component
public class TopiConsumer1 {

    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void process(String message){
        System.out.println("Consumer-1:"+ message);
    }
    
}
