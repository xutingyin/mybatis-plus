package cn.xutingyin.mybatisplus.mq;

import cn.xutingyin.mybatisplus.entity.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @Description: 生产者 
* @Author: xuty 
* @Date: 2019/10/17 14:24
*/

@Component
public class Provider {

    /**
     * 日志记录
     */
    private Logger LOG = LoggerFactory.getLogger(Provider.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(String message){
        System.out.println("Provider :" +message);
        amqpTemplate.convertAndSend("message",message);
        return "消息发送成功";
    }
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
    }
}
