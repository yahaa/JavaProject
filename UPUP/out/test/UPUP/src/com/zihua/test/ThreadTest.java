package com.zihua.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zihua on 16-10-31.
 */
public class ThreadTest {
    public static void main(String[]args)throws Exception{
        Car car=new Car();
        ExecutorService executor= Executors.newCachedThreadPool();
        executor.execute(new WaxOff(car));
        executor.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }
}

class Car{
    private boolean waxon=false;

    public synchronized void waxed(){
        waxon=true;     //waxon=true 表示打蜡结束
        notifyAll();    //通知在等待的所有线程
    }

    public synchronized void buffed(){
        waxon=false;    //waxon=false 表示抛光结束
        notifyAll();    //通知在等待的线程
    }

    public synchronized void waitForWaxing()throws InterruptedException{
        while(waxon==false){    //询问抛光是否结束，结束的话线程进入等待，等待打蜡
            wait();
        }
    }

    public synchronized void waitForBuffing()throws InterruptedException{
        while(waxon==true){     //询问是否打蜡结束，结束的话线程进入等待，等待抛光
            wait();
        }
    }

}

class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car){
        this.car=car;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("wax on");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ending wax on task");
    }
}

class WaxOff implements Runnable{
    private Car car;

    public WaxOff(Car car){
        this.car=car;
    }

    @Override
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ending wax off task");
    }
}
