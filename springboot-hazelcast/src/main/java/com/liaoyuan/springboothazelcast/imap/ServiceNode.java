package com.liaoyuan.springboothazelcast.imap;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * 服务端节点，添加数据
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class ServiceNode {

    public static void main(String[] args) {

        // 获取Hazelcast实例
        HazelcastInstance ins = Hazelcast.newHazelcastInstance();

        // 从集群中读取Map实例
        Map<Integer, String> map = ins.getMap("strawHatPirates");

        // 向集群中添加数据
        map.put(1, "Luffy");
        map.put(2, "Nami");
        map.put(3, "Zoro");
        map.put(4, "Sanji");

    }

}
