package cn.xutingyin.mybatisplus.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public String send(){
        String message = "我的第一条MQ消息";
        amqpTemplate.convertAndSend("message",message);
        return "消息发送成功";
    }

}
