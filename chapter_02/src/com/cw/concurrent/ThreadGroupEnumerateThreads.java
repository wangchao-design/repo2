package com.cw.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        Thread thread = new Thread(myGroup, ()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"myGroup");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[mainGroup.activeCount()];
        int rec = mainGroup.enumerate(list);
        System.out.println(rec);
        rec = mainGroup.enumerate(list, false);
        System.out.println(rec);
        mainGroup.list();
    }
}
