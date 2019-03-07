package com.java.ljj.explore.collectionpool;

/**
 * @author liujingjun
 * 这里总结有哪些 connection pool,他们都是怎么实现的？
 * 连接池有没有通用的设计模式？
 * Server端的conenction pool 与 client端的connection pool有什么区别？
 * 哪些有连接池呢？====》连接管理===》
 * 数据库：MySQL、Postgresql
 * 缓存：Redis、MemoryCache
 * Http服务：Nginx、Tomcat、Jetty、Flask
 * RPC：dubbo、Thrift、grpc
 * 长链接框架：Netty、Mina
 * 其他：Zookeeper
 *
 * server-Tomcat连接池：
 * sigle or two thread work with: 连接处理线程、 connection keeping pool: 连接池、multi threads: 执行器
 *
 * server-Nginx连接池：
 * master-worker 进程, select/poll/epoll 可以选择. "惊群现象"
 * can config nginx use select system io model, or when should done as this, I'm not sure, TODO check.
 *
 * server-Redis连接池：
 * io多路复用-单线程处理request
 * link: https://redis.io/topics/clients
 *
 * client-httpclient连接池：
 * client-jdbc连接池：
 * client-druid数据库连接池：
 * link: https://github.com/alibaba/druid/wiki/%E5%90%84%E7%A7%8D%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E6%B1%A0%E5%AF%B9%E6%AF%94
 *
 *
 * client-redisclient连接池：
 *
 *
 * 临时想到的：
 * nginx处理请求是进程模型，则常见的进程调度算法有哪些？其优缺点是什么？java多线程的调度算法是什么？
 * link: https://www.geeksforgeeks.org/gate-notes-operating-system-process-scheduling/
 * OS进程调度算法：
 * first come first serve
 * shortest job first
 * longest job first
 * shorteset remaining time first
 * longest remaining time firest
 * round robin scheduling
 * priority based scheduling : Response Ratio = (Waiting Time + Burst time) / Burst time
 *
 * java thread 调度算法：fixed-priority scheduling
 * java thead 设置优先级，那么，linux进程可以设置优先级吗？以linux kerner 2.6为例，其进程调度算法是？
 * (调度)
 * link: https://medium.com/hungys-blog/linux-kernel-process-scheduling-8ce05939fabd
 * (进程优先级 nice value explain)
 * link: https://www.nixtutor.com/linux/changing-priority-on-linux-processes/
 * swapper进程是做什么的？
 * linux process 是抢占式的。
 *
 * C10k 问题怎么解决？
 *
 */
public class ServerAndClientCollectionPoolMain {

    public static void main(String[] args) {

    }
}
