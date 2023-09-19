package com.metazz.learn_java.java;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 测试Collection（List和Set）
 * @Author: mazizhen
 * @CreateTime: 2023/9/18 13:51
 */
public class CollectionTest {

    public static void main(String[] args) {
        System.out.println("==========1、迭代器==========");
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("A")){
                iterator.remove();
            }
        }
        System.out.println(list);
        System.out.println("==========2、ArrayList的线程不安全问题==========");
        List<Integer> arrayList = new ArrayList<>();
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 启动两个线程同时修改 ArrayList
        executorService.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i * 10);
            }
        });
        // 等待线程池中的线程执行完毕
        executorService.shutdown();
        // 等待线程池中的任务完成
        while (!executorService.isTerminated()) {
        }
        // 打印 ArrayList 的大小
        System.out.println("ArrayList 大小：" + arrayList.size());
        System.out.println("==========3、HashMap==========");
    }

}

/*
* TreeSet的实际应用例子_词汇表
* 假设您正在开发一个文本处理程序，需要构建一个词汇表，以便存储文档中的单词，并且需要按字母顺序对单词进行排序和检索。
* 在这种情况下，您可以使用 TreeSet 来实现词汇表，确保单词按字母顺序有序存储，并能够高效地查找单词
* */
 class Vocabulary {

    private TreeSet<String> words;

    public Vocabulary() {
        // 创建一个空的词汇表，TreeSet会自动按字母顺序排序
//        words = new TreeSet<>((a,b) -> 0);
        words = new TreeSet<>();
    }

    public void addWord(String word) {
        // 向词汇表中添加单词
        words.add(word);
    }

    public boolean containsWord(String word) {
        // 检查词汇表中是否包含指定的单词
        return words.contains(word);
    }

    public void printAllWords() {
        // 打印词汇表中的所有单词
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord("apple");
        vocabulary.addWord("banana");
        vocabulary.addWord("cherry");
        vocabulary.addWord("date");
        vocabulary.addWord("banana"); // 重复添加，但不会重复存储
        System.out.println("词汇表中是否包含单词 'banana': " + vocabulary.containsWord("banana"));
        System.out.println("词汇表中是否包含单词 'grape': " + vocabulary.containsWord("grape"));
        System.out.println("词汇表中的所有单词：");
        vocabulary.printAllWords();
    }
}

