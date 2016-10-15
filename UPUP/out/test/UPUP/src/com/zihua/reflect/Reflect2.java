package com.zihua.reflect;

import java.lang.reflect.Method;
import java.util.*;
/**
 * Created by zihua on 16-10-6.
 */

public class Reflect2 {

    public static void testParment(){
        ArrayList list1=new ArrayList();
        ArrayList<String>list2=new ArrayList<String>();
        Class c1=list1.getClass();
        Class c2=list2.getClass();
        System.out.println(c1==c2);
        for(String s:list2)System.out.println(s);
        try{
            Method m=c1.getMethod("add",Object.class);
            list2.add("1234");
           // m.invoke(list2,12344);
            for(String s:list2){
                System.out.println(s);
            }
            System.out.println(list2.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testClass(){
        Test2 t=new Test2();
        Class c1=Test2.class;
        Class c2=t.getClass();
        Class c3=null;
        try{
            c3=Class.forName("com.zihua.reflect.Test2");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(c1==c2);
        System.out.println(c2==c3);
        try{
            Test2 tt=(Test2)c3.newInstance();
            tt.print();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }




    public static void main(String []args){
        testParment();
        testClass();
    }
}

class Test2{
    private String name="132413";
    public void print(){
        System.out.println(name);
    }

}


