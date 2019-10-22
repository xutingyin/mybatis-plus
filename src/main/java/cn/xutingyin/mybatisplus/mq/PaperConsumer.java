package cn.xutingyin.mybatisplus.mq;

import cn.xutingyin.mybatisplus.entity.Paper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @Description: 图书消费者
* @Author: xuty
* @Date: 2019/10/21 17:05
*/

@Component
public class PaperConsumer {

    @RabbitListener(queuesToDeclare =@Queue("paperQueue"))
    @RabbitHandler
    public void process(Paper paper) {
        try {
            System.out.println("PaperConsumer："+ paper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
