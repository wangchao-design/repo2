package com.cw.concurrent.inti;

import com.cw.concurrent.intf.DenyPolicy;
import com.cw.concurrent.intf.RunableQueue;
import com.cw.concurrent.intf.ThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunableQueue {
    //任务队列的最大容量，在构造时传入
    private final int limit;
    //若任务队列中的任务已经满了，则需要执行拒绝策略
    private final DenyPolicy denyPolicy;
    //存放任务的队列
    private final LinkedList<Runnable> runnables = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool){
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnables){
            if(runnables.size() >= limit){
                denyPolicy.reject(runnable, threadPool);
            }else{
                runnables.addLast(runnable);
                runnables.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnables){
            while(runnables.isEmpty()){
                try{
                    runnables.wait();
                }catch (InterruptedException e){
                    throw e;
                }
            }
            return runnables.removeLast();
        }
    }

    @Override
    public int size() {
       synchronized (runnables){
           return runnables.size();
       }
    }
}
