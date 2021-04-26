package com.cw.concurrent.intf;

import com.cw.concurrent.inti.RunnableDenyException;

public interface DenyPolicy {
    void reject(Runnable runnable, ThreadPool threadPool);
    //该拒绝策略会直接将任务丢弃
    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }
    //该拒绝策略会向任务提交者抛出异常
    class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnbale" + runnable + " will be abort!");
        }
    }
    //该拒绝策略会使任务在提交者所在的中执行任务
    class RunnerDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if(!threadPool.isShutDown()){
                runnable.run();
            }
        }
    }

}
