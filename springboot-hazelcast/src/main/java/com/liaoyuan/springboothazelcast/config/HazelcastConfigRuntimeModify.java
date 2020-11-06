package com.liaoyuan.springboothazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;

/**
 * 使用代码修改hazelcast的配置
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class HazelcastConfigRuntimeModify {

    public static void main(String[] args) {
        // 创建默认config对象
        Config config = new Config();

        // 获取network元素<network></network>
        NetworkConfig netConfig = config.getNetworkConfig();
        System.out.println("Default port:" + netConfig.getPort());

        // 设置组网起始监听端口
        netConfig.setPort(9701);
        System.out.println("Customer port:" + netConfig.getPort());

        // 获取join元素<join></join>，代表组网方式？
        JoinConfig joinConfig = netConfig.getJoin();

        // 获取multicast元素<multicast></multicast>
        MulticastConfig multicastConfig = joinConfig.getMulticastConfig();

        // 输出组播协议端口
        System.out.println(multicastConfig.getMulticastPort());
        // 禁用multicast协议

        multicastConfig.setEnabled(false);

        // 初始化Hazelcast
        Hazelcast.newHazelcastInstance(config);
    }

}
