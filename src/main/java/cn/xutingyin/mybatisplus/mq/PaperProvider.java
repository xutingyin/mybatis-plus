package cn.xutingyin.mybatisplus.mq;

import cn.xutingyin.mybatisplus.entity.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
* @Description: 图书 生产者
* @Author: xuty 
* @Date: 2019/10/21 17:02
*/
@Component
public class PaperProvider {
    /**
     * 日志记录
     */
    private Logger LOG = LoggerFactory.getLogger(PaperProvider.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(Paper paper){
        System.out.println("PaperProvider :" +paper);
        amqpTemplate.convertAndSend("paperQueue",paper);
        return "消息发送成功";
    }

}
