package cn.xutingyin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class SearchPaper implements Serializable {



    @Field
    private  String id;

    @Field
    private  String pageId;
    @Field
    private String name;
    @Field
    private String num;
    @Field
    private String detail;
    @Field
    private String createTime;
}
