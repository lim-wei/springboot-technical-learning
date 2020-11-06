package com.liaoyuan.springboothazelcast.introduce;


import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * 创建一个Hazelcast的slave节点,从Map、Queue中读取数据并输出
 * @author: liaoyuan
 * @create: 2020/11/05
 **/
public class HazelcastGetStartServerSlave {

    public static void main(String[] args) {

        // 创建一个 hazelcastInstance实例
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<Integer, String> clusterMap = instance.getMap("MyMap");
        Queue<String> clusterQueue = instance.getQueue("MyQueue");

        // 输出各项数据
        System.out.println("Map 1 Value:" + clusterMap.get(1));
        System.out.println("Map 2 Value:" + clusterMap.get(2));
        System.out.println("Queue Size :" + clusterQueue.size());
        System.out.println("Queue Value 1:" + clusterQueue.poll());
        System.out.println("Queue Value 2:" + clusterQueue.poll());
        System.out.println("Queue Size :" + clusterQueue.size());
    }

}
