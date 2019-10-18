package cn.xutingyin.mybatisplus.service.impl;

import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.mapper.PaperMapper;
import cn.xutingyin.mybatisplus.service.IPaperService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<Paper> selectByCondition(Paper p) {
        QueryWrapper<Paper> wrapper = new QueryWrapper();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        wrapper.lambda().ge(Paper::getCreateTime,p.getCreateTime().format(df));
        return paperMapper.selectList(wrapper);
    }
}
