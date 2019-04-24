package com.java.ljj.explore;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author liujingjun
 */
public class HelloMain {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(2);
        blockingQueue.add("hello");
        blockingQueue.add("world");
        blockingQueue.add("1111");

        blockingQueue.put("hello");
        blockingQueue.put("world");
        blockingQueue.put("1111");

        blockingQueue.offer("hello");
        blockingQueue.offer("world");
        blockingQueue.offer("1111");
        System.out.println(blockingQueue);
    }
}
