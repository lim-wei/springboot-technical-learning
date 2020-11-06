package com.liaoyuan.springboothazelcast.introduce;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * 创建一个Hazelcast的Master节点,创建一个分布式map和Queue
 * @author: liaoyuan
 * @create: 2020/11/05
 **/
public class HazelcastGetStartServerMaster {

    public static void main(String[] args) {

        // 创建一个 hazelcastInstance实例
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        // 创建了一个分布式的Map
        Map<Integer, String> clusterMap = instance.getMap("MyMap");
        clusterMap.put(1, "Hello hazelcast map!");

        // 创建分布式Queue
        Queue<String> clusterQueue = instance.getQueue("MyQueue");
        clusterQueue.offer("Hello hazelcast!");
        clusterQueue.offer("Hello hazelcast queue!");

    }

}
