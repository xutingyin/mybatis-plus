package cn.xutingyin.mybatisplus.controller;

import cn.xutingyin.mybatisplus.mq.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description: RabbitMQ 控制器
* @Author: xuty
* @Date: 2019/10/17 14:36
*/

@RestController
public class RabbitMqController {

    @Autowired
    private Provider provider;

    @GetMapping("message")
    public String sendMessage(){
        provider.send();
        return "success";
    }
}
