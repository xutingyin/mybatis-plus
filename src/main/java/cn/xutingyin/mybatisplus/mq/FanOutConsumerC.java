package cn.xutingyin.mybatisplus.mq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
* @Description: FanOut交换机消费者 A
* @Author: xuty 
* @Date: 2019/10/22 10:08
*/

@Component
public class FanOutConsumerC {

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("fanoutExchange"), exchange = @Exchange("fanoutExchange")))
    public void process(String message){
        System.out.println("FanOutConsumer-C: " + message);
    }

}
