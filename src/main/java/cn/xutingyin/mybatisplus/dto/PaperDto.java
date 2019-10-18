package cn.xutingyin.mybatisplus.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
* @Description: 书籍传输实体类
* @Author: xuty
* @Date: 2019/10/18 14:26
*/

@Data
public class PaperDto  implements Serializable {
    private  Integer pageId;
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

    /**
     * 分页对象
     */
    private Page page;
}
