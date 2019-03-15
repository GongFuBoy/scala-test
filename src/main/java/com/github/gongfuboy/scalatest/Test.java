package com.github.gongfuboy.scalatest;

/**
 * Created by ZhouLiMing on 2019/1/14.
 */
public class Test {

    public static void main(String[] args) {
        Integer integer1 = new Integer(10000);
        Integer integer2 = new Integer(10000);
        System.out.println(integer1 == integer2);
    }

}

class Person {

    public Integer age;

    public String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
