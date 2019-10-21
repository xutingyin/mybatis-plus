package cn.xutingyin.mybatisplus.controller;

import cn.xutingyin.mybatisplus.annotations.OperationLogAnnotation;
import cn.xutingyin.mybatisplus.common.RemoteModelResult;
import cn.xutingyin.mybatisplus.dto.PaperDto;
import cn.xutingyin.mybatisplus.service.IPaperService;
import cn.xutingyin.mybatisplus.vo.PaperVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 
* @Description: 书籍前端控制器 
* @Author: xuty 
* @Date: 2019/10/18 16:05
*/
@RestController
@RequestMapping("paper")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    @PostMapping("selectAll")
    @OperationLogAnnotation(name = "查询所有书籍", intoDb = false)
    public RemoteModelResult<PaperVo> selectAll(@RequestBody PaperDto paperDto){
        RemoteModelResult result = null;
        if(null != paperDto){
            result =  new RemoteModelResult();
            IPage<PaperDto> pagePapers = paperService.selectByCondition(paperDto);
            PaperVo paperVo = new PaperVo();
            paperVo.setPageNum(paperDto.getPage().getCurrent());
            paperVo.setPageSize(paperDto.getPage().getSize());
            paperVo.setTotal(pagePapers.getTotal());
            paperVo.setList(pagePapers.getRecords());
            result.setResult(paperVo);
        }
        return result;
    }
}
