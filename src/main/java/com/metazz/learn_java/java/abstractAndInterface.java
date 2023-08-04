package com.metazz.learn_java.java;

/**
 * @Description: 抽象类和接口
 * @Author: mazizhen
 * @CreateTime: 2023/8/4 9:21
 */
public class abstractAndInterface {
    public static void main(String[] args) {
        person person = new person();
        person.run(); // 调用
        person.show();
        A.test();
        person.test();
    }
}

/*
1、接口是抽象方法和常量值定义的集合
2、接口的特点：
 接口中的所有成员变量都默认是由public static final修饰的。
 接口中的所有抽象方法都默认是由public abstract修饰的。
 接口中没有构造器。
 接口采用多继承机制。【java是单继承，子类只能继承一个父类，接口则可以做到让子类继承多个类的效果】
 接口可以继承其他接口
 接口是一种特殊的抽象类，这种抽象类中只包含常量和方法的定义(JDK7.0及之前,JDK8.0可以包含静态方法)，而没有变量和方法的实现。
*/
interface breath extends A{

    String organ = "器官";  // 等价 public static final String organ = "器官";

    void show(); // 等价 public abstract void show();

    // 接口没有构造器，
    // 1是因为接口没有方法体，构造器是需要方法体的；
    // 2是因为接口不是类，是不能实例化的；
    // 3是因为一个类可以实现多个接口，如果接口有构造器，实现类在实现多个接口时，会引发构造器之间的冲突和复杂性
/*    breath(){
        System.out.println("呼吸接口的构造器");
    }*/

}

/*
抽象类的特点
 可以理解：抽象类就是比普通类多定义了抽象方法，除了不能直接进行类的实例化操作之外，并没有任何的不同
 用abstract关键字来修饰一个类，这个类叫做抽象类。
 用abstract来修饰一个方法，该方法叫做抽象方法,抽象方法没有方法体。
 含有抽象方法的类必须被声明为抽象类。
 抽象类不能被实例化。抽象类是用来被继承的，抽象类的子类必须重写父类的抽象方法，并提供方法体。若没有重写全部的抽象方法，仍为抽象类。
 不能用abstract修饰变量、代码块、构造器（构造器是需要方法体的）；
 不能用abstract修饰私有方法（抽象方法是需要子类去重写，私有方法没法重写）、final的方法（理由同上）、final的类（final类不可被继承，抽象类是用来被继承的）、静态方法（没法被重写）。
*/
abstract class animal implements breath{
    Integer leg;
    public abstract void run();

    // 抽象类可以有构造器，但是构造器不能加abstract（抽象方法不能有方法体，构造器需要方法体）
    // 抽象类构造器的作用：1、初始化变量 2、执行初始化操作
    animal(){
        leg = 4;
        System.out.println("调用抽象类的构造器");
    }

    public void test(){
        System.out.println("抽象类的非抽象方法");
    }

    @Override
    public void show() {
        System.out.println("动物用什么器官呼吸");
    }

}

class person extends animal{

    person(){
        System.out.println("调用person的构造器");
    }

    @Override
    public void run() {
        System.out.println("默认leg为" + leg);
        leg = 2;
        System.out.println("人用腿走路 " + leg);
    }

    @Override
    public void show() {
        System.out.println("人用鼻子呼吸");
    }

    @Override
    public void methodA() {
        System.out.println("接口breath的父接口的methodA()方法");
    }

}

interface A{
    void methodA();

    public static void test(){
        System.out.println("接口A的静态方法");
    }
}