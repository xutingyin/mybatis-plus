package cn.xutingyin.mybatisplus.vo;

import cn.xutingyin.mybatisplus.entity.Paper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PaperVo {
    private Integer code;
    private String msg;
    private Page<Paper> obj;

}
