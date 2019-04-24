package com.java.ljj.explore.thread.queue;

public interface JJLBlockingQueue {

    public void put(int ele) throws InterruptedException;

    public int take() throws InterruptedException;
}
