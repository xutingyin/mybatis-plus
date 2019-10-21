package cn.xutingyin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 图书实体类
 * @Auther: Tingyin.Xu  sunshinexuty@163.com
 * @Date:   @date: 2019/7/16 20:23
 *
 */
@Data
@TableName("tb_paper")
public class Paper implements Serializable {
    @TableId(type = IdType.ID_WORKER_STR)
    /**
     *自增ID
     */
    private  String pageId;
    /**
     *书籍名称
     */
    private String name;
    /**
     *书籍数量
     */
    private Integer num;
    /**
     *书籍详情
     */
    private String detail;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
