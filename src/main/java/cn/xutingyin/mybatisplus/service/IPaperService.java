package cn.xutingyin.mybatisplus.service;


import cn.xutingyin.mybatisplus.entity.Paper;

import java.util.List;

public interface IPaperService {

    List<Paper>  selectByCondition(Paper paper);
}
