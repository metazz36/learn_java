package com.metazz.learn_java.java;

/**
 * @Description: 测试拉姆达表达式
 * @Author: mazizhen
 * @CreateTime: 2023/9/14 10:21
 */
public class LambdaTest {

    public static void main(String[] args) {
        People people = new People((x) -> {System.out.println(x);return x;});
//        People people = new People( x -> x + 'a');
        System.out.println(people.skill());
        people.skill(System.out::println);
        people.skill(x -> System.out.println(x));
    }

}

class People{

    private Sport sport;

    People(Sport sport){
        String run = sport.run("2222");
        System.out.println(run);
        this.sport = sport;
    }

    public String skill(){
        return sport.run("3333");
    }

    public void skill(Live live){
        live.breathe("呼吸ing");
    }

}

interface Sport{

    String run(String str);

}

interface Live{

    void breathe(String str);

}
