package com.metazz.learn_java.java;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @Description: 测试String
 * @Author: mazizhen
 * @CreateTime: 2023/9/12 13:35
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println("=========0=========");
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false
        System.out.println(s1 == s4);// false
        System.out.println(s3 == s4);// false
        System.out.println("=========1=========");
        String ss1 = "hello";
        String ss2 = "world";
        String ss3 = "hello" + "world";
        String ss4 = ss1 + "world";
        String ss5 = ss1 + ss2;
        String ss6 = (ss1 + ss2).intern();
        String ss7 = "helloworld";
        System.out.println(ss3 == ss4);// false
        System.out.println(ss3 == ss5);// false
        System.out.println(ss4 == ss5);// false
        System.out.println(ss3 == ss6);// true
        System.out.println(ss3 == ss7);// true
        System.out.println("=========2==========");
        String x1 = "0";
        String x2 = new String("0");
        String x3 = x1 + 1;
        String x4 = x2 + 1;
        System.out.println(x3);
        System.out.println(x4);
        System.out.println(x3 == x4); // false
        System.out.println("=========3==========");
        String str = "abcdefg        ";
        System.out.println(str.substring(1,3).toUpperCase(Locale.ROOT));// BC
        System.out.println(str.endsWith("   "));
        System.out.println(str.startsWith("bc",1));
        String s = String.valueOf(123);
        // 字符串 -》 字符数组
        char[] chars1 = s.toCharArray();
        // 字符数组 -》 字符串
        char[] chars = {'a','b','c'};
        String s5 = new String(chars);
        // 字符串 -》 字节数组
        byte[] bytes1 = s5.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes1) {
            System.out.println(b);
        }
        // 字节数组 -》 字符串
        byte[] bytes = {(byte)0x61,'1','c'};
        String s6 = new String(bytes);
        System.out.println(s6);
        System.out.println("=========4==========");
        String testStr = "马";
        char[] chars2 = testStr.toCharArray();
        byte[] bytes2 = testStr.getBytes();
        System.out.println();
        System.out.println("=========5==========");
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
        System.out.println("=========6==========");
        String stra = null;
        StringBuffer sb = new StringBuffer();
        sb.append(stra);
        System.out.println(sb.length());
        System.out.println(sb);
        System.out.println("=========7==========");
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(c.equals(d));
        System.out.println(c == d);
        System.out.println(a.equals(c));
        System.out.println(a == c );
    }

}
