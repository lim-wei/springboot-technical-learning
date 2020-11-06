package com.liaoyuan.springboothazelcast.mapstore;

import com.hazelcast.core.MapStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 当Map发生数据读写时对数据库进行操作的MapStore类
 * @author: liaoyuan
 * @create: 2020/11/06
 **/
public class MapStoreExample implements MapStore<Integer, String> {

    Map<Integer, String> strawHatPirates;

    public MapStoreExample(){
        strawHatPirates = new HashMap<>();
        strawHatPirates.put(1, "Luffy");
        strawHatPirates.put(2, "Nami");
        strawHatPirates.put(3, "Chopper");
        strawHatPirates.put(4, "Sanji");
        strawHatPirates.put(5, "Usopp");
        strawHatPirates.put(6, "Zoro");
        strawHatPirates.put(7, "Brook");
        strawHatPirates.put(8, "Franky");
        strawHatPirates.put(9, "Robin");
        strawHatPirates.put(10, "Jezebel");
    }

    /**
     * MapStore接口定义了当对Map进行put、get、remove操作时会被调用实现类的store、load、delete方法，我们可以通过自己的代码来完成对数据库的写入和读取操作。
     * @param key
     * @return
     */
    @Override
    public String load(Integer key) {//读取
        if(strawHatPirates.size() < key){
            key = 0;
        }
        return strawHatPirates.get(key);
    }

    @Override
    public Map<Integer, String> loadAll(Collection<Integer> arg0) {//读取所有
        return strawHatPirates;
    }

    @Override
    public Iterable<Integer> loadAllKeys() {// 读取所有键值
        return strawHatPirates.keySet();
    }

    @Override
    public void delete(Integer key) {// 删除键值
        strawHatPirates.remove(key);
    }

    @Override
    public void deleteAll(Collection<Integer> list) {// 删除所有键值
        list.forEach( key->strawHatPirates.remove(key) );
    }

    @Override
    public void store(Integer key, String value) {// 存储键值
        strawHatPirates.put(key, value);
    }

    @Override
    public void storeAll(Map<Integer, String> map) {// 存储所有键值
        strawHatPirates.putAll(map);
    }

}
