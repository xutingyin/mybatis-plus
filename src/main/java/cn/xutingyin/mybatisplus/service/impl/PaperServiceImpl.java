package cn.xutingyin.mybatisplus.service.impl;

import cn.xutingyin.mybatisplus.dto.PaperDto;
import cn.xutingyin.mybatisplus.mapper.PaperMapper;
import cn.xutingyin.mybatisplus.service.IPaperService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @Description: 图书业务实现层
* @Author: xuty 
* @Date: 2019/10/21 16:00
*/
@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public IPage<PaperDto> selectByCondition(PaperDto paperDto) {
        IPage<PaperDto> page = paperMapper.listPaper(paperDto.getPage(), paperDto);
        return page;
    }
}
