package com.java.ljj.explore.current;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CurrentHashMapMain {
    private static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    private static final ExecutorService PRODUCER = Executors.newFixedThreadPool(10);
    private static final ExecutorService CONSUMER = Executors.newFixedThreadPool(10);


    class Producer implements Runnable {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        concurrentHashMap.replace("", "", "");
    }
}
