package cn.xutingyin.mybatisplus.mapper;

import cn.xutingyin.mybatisplus.dto.PaperDto;
import cn.xutingyin.mybatisplus.entity.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/** 
* @Description: 书籍DAO 层
* @Author: xuty 
* @Date: 2019/10/18 15:38
*/
@Mapper
@Component
public interface PaperMapper extends BaseMapper<Paper> {
    /**
     * 查询所有书籍
     * @param page
     * @param paperDto
     * @return
     */
  IPage<PaperDto> listPaper(@Param("page") Page page, @Param("paperDto") PaperDto paperDto);
}
