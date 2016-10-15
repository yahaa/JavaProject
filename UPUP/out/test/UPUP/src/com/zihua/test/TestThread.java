package com.zihua.test;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by zihua on 16-10-4.
 */
public class TestThread{

    public static void testThreadPool(){
        ExecutorService exec=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            String name="zihua"+i;
            exec.execute(new PrintTask(name));
        }
        exec.shutdown();

        exec=Executors.newFixedThreadPool(10);
        int i=10;
        while(i-->0){
            String name="haozi"+i;
            exec.execute(new PrintTask(name));
        }
        exec.shutdown();
    }

    public static void testThread(){
        try{
        Thread tt=new Thread(new PrintTask("zihua"));
        tt.start();
        tt.sleep(1);
        new Thread(new PrintTask("yahaa")).start();
        new Thread(new PrintTask("HAOZI")).start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testCallable(){
        ArrayList<Future<String>>result=new ArrayList<Future<String>>();
        ExecutorService exec=Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            result.add(exec.submit(new PrintTask2()));
        }
        try{
            for(Future<String>a:result){
                System.out.println(a.get());
                //System.out.println(a);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        exec.shutdown();
    }


    public static void testSleep(){
        Thread t=new Thread(new PrintTask3());
        try{
            t.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(t.getPriority()+"jjjj");
        t.setPriority(4);
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.getName());
        t.start();


    }



    public static void main(String[]args){
        // testThreadPool();
        // testThread();
        //testCallable();
        testSleep();

    }
}

class PrintTask implements Runnable{
    private static int count=0;
    private final int id=count++;
    private String name=null;


    public PrintTask(String name){
        this.name=name;
    }

    public void run(){
        System.out.println(name+" "+id);
        for(int i=1;i<=1000;i++){
            System.out.print(" ("+id+") ");
            if(i%10==0)System.out.println();
        }
        System.out.println("finished "+id);
    }
}


class PrintTask2 implements Callable<String>{
    private static int count=0;
    private final int id=count++;
    @Override
    public String call(){
        return "hahaha"+id;
    }
}

class PrintTask3 implements Runnable{
    public void run(){
        for(int i=0;i<100;i++)System.out.println(i);
    }
}

