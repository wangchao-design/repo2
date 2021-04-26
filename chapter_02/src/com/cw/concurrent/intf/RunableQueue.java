package com.cw.concurrent.intf;

public interface RunableQueue {
    //当有新的任务进来时首先会offer到队列中
    void offer(Runnable runnable);
    //工作现成通过take方法获取Runnable
    Runnable take() throws InterruptedException;
    //获取任务队列中任务的数量
    int size();
}
