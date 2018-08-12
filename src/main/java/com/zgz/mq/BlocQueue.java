package com.zgz.mq;

import java.util.concurrent.LinkedBlockingQueue;

public class BlocQueue {
    private static LinkedBlockingQueue<String> blockingQueue= new LinkedBlockingQueue<>(5000);

    public String get() throws InterruptedException {
        return blockingQueue.take();
    }

    public void put(String msg) throws InterruptedException {
        blockingQueue.put(msg);
    }
    public int size(){
        return blockingQueue.size();
    }
    public void clear(){
        blockingQueue.clear();
    }
}
