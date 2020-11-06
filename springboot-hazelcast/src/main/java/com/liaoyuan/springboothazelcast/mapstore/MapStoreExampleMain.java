package com.liaoyuan.springboothazelcast.mapstore;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author: linw
 * @create: 2020/11/06
 **/
public class MapStoreExampleMain {

    public static void main(String[] args) throws FileNotFoundException {
        // 加载配置
        Config config = new ClasspathXmlConfig("xmlconfig/map-store.xml");

        // 创建Hazelcast实例
        HazelcastInstance ins = Hazelcast.newHazelcastInstance(config);

        // 获取Map
        Map<Integer, String> map = ins.getMap("demo");

        // 输出第一条数据
        println(map.get(1));

        // 添加一条数据
        map.put(11, "Gaillot");
        // 输出第一条数据
        System.out.println(map.get(11));

        // 移除添加的数据
        map.remove(11);
        // 输出被移除的数据
        System.out.println(map.get(11));
    }
    static private void println(Object obj){
        System.out.println(obj);
    }

}
