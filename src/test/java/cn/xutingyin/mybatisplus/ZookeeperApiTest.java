package cn.xutingyin.mybatisplus;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperApiTest implements Watcher {
    /**
     * 连接的节点信息，如果多个节点，中间都英文逗号分隔开
     *
     * 注：在zookeeper集群的模式下，连接单个节点和所有集群节点进行操作是一样的，
     *
     */
    String connectString = "xutingyin.cn:2181,xutingyin.cn:2182,xutingyin.cn:2183";
    private static int sessionTimeout = 200;

    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper = null;

    /**
     * 获取连接
     */
    @Before
    public void getConnection() {
        try {
            zooKeeper = new ZooKeeper(connectString, sessionTimeout, this);
            System.out.println(zooKeeper.getState());
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    @After
    public void releseConnection() {
        if (null != zooKeeper) {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }

    /**
     * 创建节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = "/secondNode";
        String data = "hello";
        List<ACL> acls = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        // 持久性节点
        CreateMode createMode = CreateMode.PERSISTENT;
        String createResult = zooKeeper.create(path, data.getBytes(), acls, createMode);
        System.out.println("createResult  " + createResult);

    }

    /**
     * 删除节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void deleteNode() throws KeeperException, InterruptedException {
        // 删除节点路径
        String deletePath = "/secondNode";
        // -1 表示匹配任意版本
        int version = -1;
        zooKeeper.delete(deletePath, version);
    }

    /**
     * 获取所有子节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void listNodes() throws KeeperException, InterruptedException {
        String listPath = "/";
        boolean watch = true;
        List<String> childrens = zooKeeper.getChildren(listPath, watch);
        childrens.forEach(System.out::println);

    }

    /**
     * 获取节点 下点数据信息
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void listDataByNode() throws KeeperException, InterruptedException {
        String listPath = "/secondNode";
        boolean watch = true;
        Stat stat = null;
        byte[] data = zooKeeper.getData(listPath, watch, stat);
        System.out.println(new String(data));

    }

    /**
     * 更新数据
     */
    @Test
    public void setData() throws KeeperException, InterruptedException {
        String listPath = "/secondNode";
        boolean watch = true;
        Stat Stat = zooKeeper.setData(listPath, "hello_update".getBytes(), -1);
        System.out.println("第一次修改后的版本号： " + Stat.getAversion());
        Stat Stat2 = zooKeeper.setData(listPath, "hello_update_2".getBytes(), Stat.getVersion());
        System.out.println("第二次修改后的版本号： " + Stat2.getAversion());

    }

    /**
     * 判断节点是否存在
     */
    @Test
    public void existNode() throws KeeperException, InterruptedException {
        String listPath = "/secondNode2";
        boolean watch = true;
        Stat stat = zooKeeper.exists(listPath, watch);
        System.out.println("该节点信息： " + stat);
    }

}
