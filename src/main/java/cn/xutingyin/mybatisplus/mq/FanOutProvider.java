package cn.xutingyin.mybatisplus.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @Description:
* @Author: xuty
* @Date: 2019/10/22 9:59
*/
@Component
public class FanOutProvider {
    Logger logger = LoggerFactory.getLogger(FanOutProvider.class);

    @Autowired
    private AmqpTemplate rabbitTeplate;

    public void send() {
        try {
            String context = "hi, fanout msg ";
            System.out.println("Sender : " + context);
            rabbitTeplate.convertAndSend("fanoutExchange","",context);
        } catch (AmqpException e) {
            logger.error("FanOutProvider.send() 出现异常,",e);
        }
    }
}
