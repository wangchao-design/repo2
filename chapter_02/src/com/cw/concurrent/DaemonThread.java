package com.cw.concurrent;

import java.util.concurrent.TimeUnit;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(() -> {
//            while(true){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//        Thread.sleep(2000L);
//        System.out.println("l");
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        try{
            TimeUnit.MINUTES.sleep(1);
        }catch (InterruptedException e){
            System.out.println("I will be interrupted still.");
        }
    }
}
