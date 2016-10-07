package com.zihua.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;

/**
 * Created by zihua on 16-10-6.
 */
public class Reflect3 {
    public static void main(String[]args){
        BigInteger a=BigInteger.ONE;
        getAllMessage(a);
    }

    public static void getAllMessage(Object o){
        Class t=o.getClass();
        System.out.println(t.getName());
        Method []a=t.getMethods();
        System.out.println(a.length);

        for(Method ts:a){
            System.out.println(ts);
        }

        Constructor []aa=t.getConstructors();
        for(Constructor tss:aa){
            System.out.println(tss);
        }
        Method []aaa=t.getDeclaredMethods();
        for(Method ms:aaa)System.out.println(ms);
        System.out.println(aaa.length);

        Field []aaaa=t.getFields();
        for(Field ar:aaaa)System.out.println(ar);
    }


}
