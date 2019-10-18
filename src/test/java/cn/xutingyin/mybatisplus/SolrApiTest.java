package cn.xutingyin.mybatisplus;

import cn.xutingyin.mybatisplus.entity.Paper;
import cn.xutingyin.mybatisplus.entity.SearchPaper;
import cn.xutingyin.mybatisplus.entity.Star;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrApiTest {
    final String solrUrl = "http://xutingyin.cn:8983/solr/";
    String coreName = "mworld";
    SolrClient solrClient = null;

    @Autowired
    SolrTemplate solrTemplate;

    /**
     * 创建连接
     */
    @Before
    public void createServer() {
        solrClient = new HttpSolrClient.Builder(solrUrl + coreName)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
//        System.out.println(solrClient + " 客户端创建成功");
    }

    /**
     * 提交事务
     * 释放连接
     *
     * @throws IOException
     * @throws SolrServerException
     */
    @After
    public void releaseConnection() throws IOException, SolrServerException {
        if (null != solrClient) {
            solrClient.commit();
            solrClient.close();
        }
    }

    @Test
    public void addDocument() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        //id 域必须要有，是进行schema.xml 中作为主键进行区分不同记录的标识
        document.addField("id", UUID.randomUUID().toString());
        document.addField("name", "周星星".toString());
        document.addField("age", "25");
        document.addField("address", "广东省-深圳市-宝安区-西乡-桃源居");
        solrClient.add(document);
    }

    @Test
    public void deleteDocumentById() throws IOException, SolrServerException {
        solrClient.deleteById("8");
    }

    @Test
    public void deleteDocumentByQuery() throws IOException, SolrServerException {
        // 删除所有的记录
        solrClient.deleteByQuery("*:*");

    }

    @Test
    public void deleteDocumentByQuery2() throws IOException, SolrServerException {
        // 删除所有的记录
        Query query = new SimpleQuery();
        Criteria num = new Criteria("num");
        num.is(1);
        Criteria name = new Criteria("name");
        name.is("卢中南欧阳询钢笔书法集-----");
        query.addCriteria(num);
        query.addCriteria(name);
        solrTemplate.delete("mworld", query);

    }


    @Test
    public void listDocuments() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery("*:*");
        query.addField("id");
        query.addField("name");
        query.setSort("id", SolrQuery.ORDER.asc);
        QueryResponse response = solrClient.query(query);
        List<Star> results = response.getBeans(Star.class);
        results.forEach(System.out::println);
    }

    @Test
    public void addPaperBean() throws IOException, SolrServerException {
        SearchPaper paper = SearchPaper.builder()
                .num("1")
                .detail("卢中南欧阳询钢笔书法集")
                .name("卢中南欧阳询钢笔书法集")
                .pageId("1")
                .build();

        UpdateResponse updateResponse = solrClient.addBean(paper);
        System.out.println(updateResponse.getStatus());
    }

    @Test
    public void addPaperBean2() throws IOException, SolrServerException {
        SearchPaper paper = SearchPaper.builder()
                .id("d912baaa-93c1-49b7-b0d2-a008ff9a5821")
                .num("1")
                .name("卢中南欧阳询钢笔书法集")
                .detail("卢中南欧阳询钢笔书法集11111----")
                .pageId("1")
                .build();



        UpdateResponse updateResponse = solrTemplate.saveBean("mworld", paper);
        System.out.println(updateResponse.getStatus());
    }
    @Test
    public void updatePaperBean() throws IOException, SolrServerException {
        Query query = new SimpleQuery();
        Criteria num = new Criteria("num");
        num.is(1);
        Criteria name = new Criteria("detail");
        name.is("卢中南欧阳询钢笔书法集333-----");
        query.addCriteria(num);
        query.addCriteria(name);

        Page<SearchPaper> pages = solrTemplate.query("mworld", query, SearchPaper.class);
        List<SearchPaper> content = pages.getContent();
        SearchPaper searchPaper = content.get(0);
        searchPaper.setName("11111111111111");
        UpdateResponse updateResponse = solrTemplate.saveBean("mworld", searchPaper);
        System.out.println(updateResponse.getStatus());
    }
}
