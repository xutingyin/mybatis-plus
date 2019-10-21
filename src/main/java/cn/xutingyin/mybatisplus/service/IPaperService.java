package cn.xutingyin.mybatisplus.service;


import cn.xutingyin.mybatisplus.dto.PaperDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
/** 
* @Description: 图书业务层
* @Author: xuty 
* @Date: 2019/10/21 16:01
*/
public interface IPaperService {

    IPage<PaperDto> selectByCondition(PaperDto paperDto);
}
