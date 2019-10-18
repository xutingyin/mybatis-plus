package cn.xutingyin.mybatisplus;

import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.mapper.PaperMapper;
import cn.xutingyin.mybatisplus.service.IPaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private PaperMapper paperMapper;

    @Test
    public void contextLoads() {
    }


    @Test
    public void listPapers(){
        List<Paper> papers = paperMapper.selectList(null);
        papers.forEach(System.out::println);
    }

    @Test
    public void addPaper(){
        // LocalDateTime 转换为时间戳
        long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // 时间戳转换为 LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(now / 1000, 0, ZoneOffset.ofHours(8));
        Paper paper =  new Paper();
//                .createTime(localDateTime)
        paper.setCreateTime(LocalDateTime.now());
        paper.setName("围城");
        paper.setDetail("钱钟书-围城");
        paper.setNum(1);
        paperMapper.insert(paper);
    }
}
