package com.cw.concurrent.inti;

import com.cw.concurrent.intf.RunableQueue;

public class InternalTask implements Runnable{
    private final RunableQueue runableQueue;
    private volatile boolean running = true;
    public InternalTask(RunableQueue runableQueue){
        this.runableQueue = runableQueue;
    }
    @Override
    public void run() {
        //如果当前任务为running并且没有被中断，则其将不断从queue中获取runable，然后执行run方法
        while(running && !Thread.currentThread().isInterrupted()){
            Runnable task = null;
            try {
                task = runableQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
        }
    }
    //停止当前任务，主要会在线程池的shutdown方法中使用
    public void stop(){
        this.running = false;
    }
}
