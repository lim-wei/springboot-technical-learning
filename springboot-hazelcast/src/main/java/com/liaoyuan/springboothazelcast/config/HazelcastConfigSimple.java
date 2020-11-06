package com.liaoyuan.springboothazelcast.config;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * 从xml中加载hazelcast配置并输出相关信息
 * xml配置和代码配置是可以混合使用的
 * 先加载XML配置再对其进行修改以满足各种需要
 * 每个XML元素对应一个Java实体或数据，只要按照XML配置文件的树形关系来调用get或set，就可以在源码中获取和设置所有配置数据
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class HazelcastConfigSimple {

    public static void main(String[] args) {

        /**
         * 从classpath加载配置文件
         * hazelcast提供了多种初始化配置文件的方法，主要有：
         * ClasspathXmlConfig: 从classpath路径加载配置文件,根目录可以认为是classes文件夹
         * FileSystemXmlConfig: 从文件系统加载配置文件,路径为绝对路径
         * UrlXmlConfig: 从网络地址获取配置文件
         * InMemoryXmlConfig: 从内存中的xml字符串生成配置文件
         * XmlConfigBuilder: 从InputStream流中读取配置文件。使用Config cfg = new XmlConfigBuilder(inputStream).build()可以创建一个Config实例
         */
        Config config = new ClasspathXmlConfig("xmlconfig/simple-config.xml");
        // 获取网络配置
        NetworkConfig netConfig = config.getNetworkConfig();

        // 获取用户定义的map配置，demo.config为用户定义的配置名
        MapConfig mapConfigXml = config.getMapConfig("demo.config");

        // 获取系统默认的map配置，default时系统默认配置名
        MapConfig mapConfigDefault = config.getMapConfig("default");

        // 输出集群监听的起始端口号
        System.out.println("Current port:" + netConfig.getPort());

        // 输出监听端口的累加号
        System.out.println("Current port count:" + netConfig.getPortCount());

        // 输出自定义map的备份副本个数
        System.out.println("Config map backup count:" + mapConfigXml.getBackupCount());

        // 输出默认map的备份副本个数
        System.out.println("Default map backup count:" + mapConfigDefault.getBackupCount());

        // 测试创建Hazelcast实例并读写测试数据
        HazelcastInstance instance1 = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance instance2 = Hazelcast.newHazelcastInstance(config);

        // 添加数据
        Map<Integer, String> defaultMap1 = instance1.getMap("defaultMap");
        defaultMap1.put(1, "testMap");
        Map<Integer, String> configMap1 = instance1.getMap("configMap");
        configMap1.put(1, "configMap");

        // 输出数据
        Map<Integer, String> testMap2 = instance2.getMap("defaultMap");
        System.out.println("Default map value:" + testMap2.get(1));
        Map<Integer, String> configMap2 = instance2.getMap("configMap");
        System.out.println("Config map value:" + configMap2.get(1));
    }

}
