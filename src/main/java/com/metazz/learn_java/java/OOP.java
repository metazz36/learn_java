package com.metazz.learn_java.java;

/**
 * @Description: 面向对象编程oop
 * @Author: mazizhen
 * @CreateTime: 2023/9/19 9:17
 */
public class OOP {

    // score1~4测试权限修饰符
    public int score1;
    protected int score2;
    int score3;
    private int score4;
    public void test(){

    }

    /*
    * 1、成员变量有默认初始值，局部变量没有默认初始值，必须显式赋值才能使用（Person静态代码块的age）
    * 2、Java权限修饰符public、protected、(缺省)、private置于类的成员定义前，用来限定对象对该类成员的访问权限。
    * 3、对于class的权限修饰只可以用public和default(缺省)。
    * 4、子类不能直接访问父类中私有的(private)的成员变量和方法。
    * */
    public static void main(String[] args) {
        Person1 person1 = new Person1(3,"mzz",true);
        System.out.println(person1);
        person1.print("a","b","c");
        //下面两次调用将执行第二个test方法
        person1.test1();
        person1.test1("aa" , "bb");
        person1.test1("bb");
        //下面将执行第一个test方法
        person1.test(new String[]{"aa"});
        System.out.println("=========多态=========");
        Person1 mzz = new Child(person1.age,person1.name,true,100);
        mzz.show();// 调用子类的show方法
        System.out.println((mzz instanceof Child));
        System.out.println((mzz instanceof Person1));
        System.out.println(person1 instanceof Child);
    }

}

class Person1{

    public int age = 2;

    public String name;

    private Boolean gender; // true为男

    {
        int age = 1;
        this.age = age;
        this.name = "metazz";
        this.gender = true;
    }

    public Person1(int age, String name, Boolean gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public void print(String...info){
        for (String s : info) {
            System.out.println(s);
        }
    }

    public void show(){
        System.out.println("父类的show方法");
    }

    public void test(String[] books){
        System.out.println("含字符串数组参数的test方法 ");
    }
    public void test1(String book){
        System.out.println("****与可变形参方法构成重载的test1方法****");
    }
    public void test1(String ... books){
        System.out.println("****形参长度可变的test1方法****");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

}

class Child extends Person1{

    public Child(int age, String name, Boolean gender) {
        super(age, name, gender);
        System.out.println("调用父类的构造器");
    }

    public Child(int age, String name, Boolean gender,int score){
        this(age, name, gender);
        System.out.println("调用四个参数的构造器: " + score);
    }

    public void show(){
        System.out.println("子类的show方法");
    }

}
