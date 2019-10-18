package cn.xutingyin.mybatisplus.controller;

import cn.xutingyin.mybatisplus.annotations.OperationLogAnnotation;
import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paper")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    @PostMapping("selectAll")
    @OperationLogAnnotation(name = "查询所有书籍", intoDb = false)
    public List<Paper> selectAll(@RequestBody Paper paper){
        List<Paper> papers = paperService.selectByCondition(paper);
        return papers;
    }
}
