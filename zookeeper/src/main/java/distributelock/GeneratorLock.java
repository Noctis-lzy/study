package distributelock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * https://blog.csdn.net/TG229dvt5I93mxaQ5A6U/article/details/78373641?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 */
//
public class GeneratorLock {
    public static void main(String[] args) throws Exception {
//创建zookeeper的客户端

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        CuratorFramework client = CuratorFrameworkFactory.newClient("10.21.41.181:2181,10.21.42.47:2181,10.21.49.252:2181", retryPolicy);

        client.start();

//创建分布式锁, 锁空间的根节点路径为/curator/lock

        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

        mutex.acquire();

//获得了锁, 进行业务流程

        System.out.println("Enter mutex");

//完成业务流程, 释放锁

        mutex.release();

//关闭客户端

        client.close();

    }
}
