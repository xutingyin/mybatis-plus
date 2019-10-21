package cn.xutingyin.mybatisplus.vo;

import cn.xutingyin.mybatisplus.dto.PaperDto;
import cn.xutingyin.mybatisplus.entity.Paper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/** 
* @Description: 书籍 视图层实体类 
* @Author: xuty 
* @Date: 2019/10/21 15:10
*/
@Data
public class PaperVo {
    private Long pageSize;
    private Long pageNum;
    private Long total;
    public List<PaperDto> list;

}
