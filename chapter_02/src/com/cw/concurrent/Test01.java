package com.cw.concurrent;

import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {
       Thread t1 = new Thread("t1");
       ThreadGroup group = new ThreadGroup("TestGroup");
       Thread t2 = new Thread(group,"t2");
       ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainThreadGroup);
        System.out.println(mainThreadGroup == t1.getThreadGroup());
        System.out.println(mainThreadGroup == t2.getThreadGroup());
        System.out.println(group == t2.getThreadGroup());
    }
}
