package com.zihua.test;

/**
 * Created by zihua on 16-10-1.
 */
public class EnumTest {
    public static void main(String[]args){
        for(Season s:Season.values()){
            System.out.println(s);
        }
        System.out.println(Season.SPRING.compareTo(Season.WINTER));
        Gender g=Enum.valueOf(Gender.class,"FEMALE");
        System.out.println(g.getName());
    }
}

enum Season{
    SPRING,SUMMER,FALL,WINTER;
}

enum Gender{
    NALE("nan"),FEMALE("nv");
    private String name;
    private Gender(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
