package com.liaoyuan.springboothazelcast.imap;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * 客户端节点，读取数据
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class ClientNode {

    public static void main(String[] args) {

        // 获取Hazelcast实例
        HazelcastInstance ins = Hazelcast.newHazelcastInstance();

        // 从集群中读取Map实例
        Map<Integer, String> map = ins.getMap("strawHatPirates");

        // 输出map中数据
        map.forEach((k,v)-> System.out.println("Pos:" + k + ". name:" + v));

    }

}
