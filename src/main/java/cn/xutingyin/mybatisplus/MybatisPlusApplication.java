package cn.xutingyin.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/** 
* @Description: mybatisPlus 启动类
* @Author: xuty 
* @Date: 2019/10/18 16:06
*/

@SpringBootApplication
@MapperScan("cn.xutingyin.mybatisplus.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
