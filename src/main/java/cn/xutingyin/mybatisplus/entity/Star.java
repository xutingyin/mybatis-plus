package cn.xutingyin.mybatisplus.entity;

import lombok.Builder;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @Description: 明星实体类
 * @Author: xuty
 * @Date: 2019/8/23 15:33
 */

@Data
@Builder(toBuilder = true)
public class Star implements Serializable {

    @Field
    public String id;
    @Field
    public String name;
    @Field
    public Integer age;
    @Field
    public String address;
}
