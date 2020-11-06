package com.liaoyuan.springboothazelcast.introduce;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * 创建一个区别于服务端的客户端节点client，需要引入另外的包
 * 客户端与服务端最大的不同是：它不会存储数据也不能修改集群中的数据
 * 客户端的console输出内容比服务端少了很多，这是因为客户端不必承载服务端的数据处理功能，也不必维护各种节点信息
 * @author: liaoyuan
 * @create: 2020/11/05
 **/
public class HazelcastGetStartClient {

    public static void main(String[] args) {

        // 使用client来组建集群
        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);

        Map<Integer, String> clusterMap = instance.getMap("MyMap");
        Queue<String> clusterQueue = instance.getQueue("MyQueue");

        // 输出各项数据
        System.out.println("Map Value:" + clusterMap.get(1));
        System.out.println("Queue Size :" + clusterQueue.size());
        System.out.println("Queue Value 1:" + clusterQueue.poll());
        System.out.println("Queue Value 2:" + clusterQueue.poll());
        System.out.println("Queue Size :" + clusterQueue.size());

    }

}
