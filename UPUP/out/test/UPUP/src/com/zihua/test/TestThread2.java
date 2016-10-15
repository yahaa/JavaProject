package com.zihua.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by zihua on 16-10-6.
 */
public class TestThread2 {
    public static void main(String[]args)throws Exception{
        for(int i=0;i<10;i++){
            Thread d=new Thread(new TestDaemon());
            d.setDaemon(true);
            d.start();
        }
        System.out.println("all Thread started");
        TimeUnit.MICROSECONDS.sleep(100000);

    }
}

class TestDaemon implements Runnable{
    public void run(){
        try{
            while(true){
                TimeUnit.MICROSECONDS.sleep(1000);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }
        catch(Exception e){
            System.out.println("sleep");
        }
    }
}
