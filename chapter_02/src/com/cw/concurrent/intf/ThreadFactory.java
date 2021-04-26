package com.cw.concurrent.intf;

public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
