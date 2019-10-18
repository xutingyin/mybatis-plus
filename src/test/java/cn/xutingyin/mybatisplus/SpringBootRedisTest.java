package cn.xutingyin.mybatisplus;

import cn.xutingyin.mybatisplus.entity.Star;
import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void put() {
        stringRedisTemplate.opsForValue().set("test", "hello redis update");
    }


    @Test
    public void delete() {
        Boolean sunshine = stringRedisTemplate.delete("test");
    }

    @Test
    public void get(){
        String sunshine = stringRedisTemplate.opsForValue().get("test");
        System.out.println(sunshine);
    }

    @Test
    public void putObj(){
        Star star = Star.builder()
                .id("1")
                .name("sunshine")
                .age(22)
                .address("广东省深圳市宝安区西乡桃源居").build();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test", star);
    }

    @Test
    public void getObj(){
        Star test = (Star) redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }


    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer =  new StringRedisSerializer();
        RedisSerializer jdkSerializationRedisSerializer =  new JdkSerializationRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
        this.redisTemplate = redisTemplate;
    }
}
