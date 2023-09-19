package com.metazz.learn_java.java;

import java.util.HashMap;

/**
 * @Description: 测试Stream数据流
 * @Author: mazizhen
 * @CreateTime: 2023/9/14 10:50
 */
public class StreamTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(8,8);map.put(3,3);map.put(4,4);map.put(5,5);map.put(7,7);
        System.out.println(map.keySet().stream().allMatch(a -> a % 2 == 1));
        System.out.println(map.values());
        System.out.println(map.values().stream().count());
        System.out.println(map.values().stream().max((a,b) ->  b - a));
        System.out.println(map.values().stream().min((a,b) -> b - a));
        System.out.println(map.values().stream().findFirst());
        System.out.println(map.values().stream().findAny());
    }

}
