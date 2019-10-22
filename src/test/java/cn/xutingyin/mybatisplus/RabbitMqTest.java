package cn.xutingyin.mybatisplus;

import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.mq.FanOutProvider;
import cn.xutingyin.mybatisplus.mq.PaperProvider;
import cn.xutingyin.mybatisplus.mq.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @Description: Rabbit使用测试
* @Author: xuty
* @Date: 2019/10/21 16:12
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private Provider provider;
    @Autowired
    private Provider provider2;

    @Autowired
    private PaperProvider paperProvider;

    @Autowired
    private FanOutProvider fanOutProvider;

    /**
     * 一个生产者对应两个消费者
     */
    @Test
    public void oneToMany(){
        for (int i=0;i<100;i++) {
            provider.send(i+"");

        }
    }

    /**
     * 两个消费者对应两个生产者
     */
    @Test
    public void manyToMany(){
        for (int i=0;i<100;i++) {
            provider.send(i+"");
            provider2.send(i+"");
        }
    }

    /**
     * Java 自定义对象消费
     * RabbitMQ 对对象的传输完美支持，只需要在生产者和消费者处同时使用相同的对象即可
     * --
     */
    @Test
    public void sendObj(){
        Paper paper = new Paper();
        paper.setName("你听懂了吗");
        paper.setNum(1);
        paper.setDetail("国民教授-戴建业");
        paperProvider.send(paper);
    }

    @Test
    public void topicSend(){
        /**
         * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息
         */
        provider.send1();

        /**
         * 发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
         */
//        provider.send2();
    }

    @Test
    public void fanOutSend() {
        fanOutProvider.send();
    }
}
