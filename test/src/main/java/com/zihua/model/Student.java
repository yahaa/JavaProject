package com.zihua.model;

/**
 * Created by zihua on 16-12-17.
 */
public class Student {
    private String name;
    private int age;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayName() {

        System.out.println("my name is " + name);
    }
}
