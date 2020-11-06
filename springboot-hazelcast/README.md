# Hazelcast学习与使用
参考博客：https://my.oschina.net/chkui/blog/729698

分为以下包<br>
**introduce**：hazelcast初步介绍与简单使用，包括实例化以及数据的读取<br>

**config**：自定义hazelcast的配置文件，读取配置信息，代码修改配置信息以及配置信息解析等。
 如果用户没有指定或提供任何配置文件，Hazelcast默认会使用jar包中自带的配置文件——"hazelcast-default.xml"来配置Hazelcast的运行环境。
 Hazelcast默认采用XML格式作为配置文件，当然也支持其他配置方法。
 Hazelcast以分布式的方式实现了Java中的绝大部分数据结构，XML配置文件中相关的就是用来配置数据结构，从字面上看，大概就是配置map的备份副本个数、释放策略、释放比率等等。

**imap**：hazelcast数据结构imap的使用和配置解析

**mapstore**: 使用mapstore进行数据持久化的示例