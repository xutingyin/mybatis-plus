package cn.xutingyin.mybatisplus;

import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.mapper.PaperMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private PaperMapper paperMapper;

    @Test
    public void select(){
        List<Paper> papers = paperMapper.selectList(null);
        Assert.assertEquals(1,papers.size());

    }

}
