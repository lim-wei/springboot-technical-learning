package com.liaoyuan.springboothazelcast.imap;

import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapIndexConfig;

/**
 * hazelcast的map配置
 * 参考链接：https://my.oschina.net/chkui/blog/746496
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class StaticMapConfig {

    public static void main(String[] args) {

        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("cacheMap") // 设置Map名称
                .setInMemoryFormat(InMemoryFormat.BINARY) // 设置内存格式
                .setBackupCount(1) // 设置副本个数，每个节点会按条目（Entry）数将数据进行分布，并且每条数据都会有备份。
                .setAsyncBackupCount(0) //  设置异步备份数，如果是一定不能丢失的数据，最好用同步方法，如果备份出现异常，会马上通知到调用线程然后执行补偿操作。
                .setReadBackupData(true);// 设置为false表示只能从主表数据读取，设置为true表示可以从备份副本中读取数据,但是设置为true可能会导致“数据脏读”

        mapConfig.getMapStoreConfig()//
                .setWriteDelaySeconds(60) //
                .setWriteBatchSize(1000); // 设置缓存格式

        mapConfig.addMapIndexConfig(new MapIndexConfig().setAttribute("id").setOrdered(true)); // 增加索引
        mapConfig.addMapIndexConfig(new MapIndexConfig().setAttribute("name").setOrdered(true));

    }

}
