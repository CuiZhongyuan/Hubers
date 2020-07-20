package com.hubers.utils.hashmaptraverse;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 在 Java 中遍历 HashMap 的5种最佳方法
 * @author  czy
 *
 */
public class IteratorHashMapEntrySet {

    @Test
    public void entrySetTraverse(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"C");
        map.put(4,"c++");
        map.put(5,"go");
        // 1. 使用 Iterator 遍历 HashMap EntrySet
        Iterator<Map.Entry<Integer, String>> integrator = map.entrySet().iterator();
        while (integrator.hasNext()){
            Map.Entry< Integer, String > entry = integrator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    @Test
    public  void keySetTraverse() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"C");
        map.put(4,"c++");
        map.put(5,"go");

        // 2. 使用 Iterator 遍历 HashMap KeySet
        Iterator < Integer > iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Test
    public  void foreachTraverse() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"C");
        map.put(4,"c++");
        map.put(5,"go");

        // 3. 使用 For-each(增加for) 循环遍历 HashMap
        for (Map.Entry < Integer, String > entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Test
    public static void lambdaTraverse() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"C");
        map.put(4,"c++");
        map.put(5,"go");

        // 4. 使用 Lambda 表达式遍历 HashMap
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public static void streamTraverse() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"C");
        map.put(4,"c++");
        map.put(5,"go");

        // 5. 使用 Stream API 遍历 HashMap
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

}
