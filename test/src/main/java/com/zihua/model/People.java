package com.zihua.model;

import com.zihua.model.Dog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zihua on 16-12-17.
 */
public class People {
    private String name;
    private int age;
    private int id;
    private Dog dog;
    private List<String> hobbies = new ArrayList<String>();
    private Map<String, String> works = new HashMap<String, String>();

    public People() {
    }

    public People(String name, int age, int id, Dog dog) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.dog = dog;
    }

    public Map<String, String> getWorks() {
        return works;
    }

    public void setWorks(Map<String, String> works) {
        this.works = works;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
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

    @Override
    public String toString() {
        return "[" + name + "," + age + "," + id + "," + dog.getName() + "]" + hobbies + works;
    }
}
