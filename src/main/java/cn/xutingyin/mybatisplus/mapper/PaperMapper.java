package cn.xutingyin.mybatisplus.mapper;

import cn.xutingyin.mybatisplus.entity.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface PaperMapper extends BaseMapper<Paper> {

}
