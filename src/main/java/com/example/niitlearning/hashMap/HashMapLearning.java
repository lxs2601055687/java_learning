package com.example.niitlearning.hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapLearning {
    public static void main(String[] args) {
        HashMap<Integer, Integer>  hashMap = new HashMap<>();
        //添加
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        //哈希表的遍历方法一
        for (Integer key : hashMap.keySet()) {
            System.out.println("key: " + key + " value: " + hashMap.get(key));
        }
        //哈希表的遍历方法二
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        //哈希表的遍历方法三
        hashMap.forEach((key, value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

        //获取
        System.out.println(hashMap.get(2));
        //删除
        hashMap.remove(1);
        //判断是否存在
        System.out.println(hashMap.containsKey(1));
        //获取所有的value
        Collection<Integer> values = hashMap.values();
        //获取所有的key
        Collection<Integer> keys = hashMap.keySet();
        //可以存null？
        hashMap.put(null, null);
        System.out.println(hashMap.get(null));

        //先看全局变量，再看属性，再看静态内部类，然后public方法，最后private方法

    }
}
