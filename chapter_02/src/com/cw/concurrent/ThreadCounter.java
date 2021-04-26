package com.cw.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter extends  Thread{
    final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try{
            while(true){
                new ThreadCounter().start();
            }
        }catch (Throwable e){
            System.out.println("failed At=>" + counter.get());
        }
    }

    @Override
    public void run() {
        System.out.println("The "+counter.getAndIncrement() + " thread be created");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
