package com.zihua.reflect;
import java.net.URL;
/**
 * Created by zihua on 16-10-6.
 */


public class Reflect1 {
    public static void testLoader(){

        ClassLoader loader= ClassLoader.getSystemClassLoader();
        try{
            Class<?> test = loader.loadClass("com.zihua.reflect.Test");
            //System.out.println(test.getName());
            Class.forName("com.zihua.reflect.Test");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void testBootstrap(){
        URL []urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL t:urls){
            System.out.println(t);
        }
    }


    public static void main(String[]args){
      //testLoader();
        testBootstrap();
    }

}

class Test{
    static{
        System.out.println("hahahaha");
    }

    static  String compile="jujuju";
}


