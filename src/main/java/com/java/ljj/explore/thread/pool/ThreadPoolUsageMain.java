package com.java.ljj.explore.thread.pool;


import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolUsageMain {
    private static volatile AtomicInteger count = new AtomicInteger(0);
    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(
            1, 2, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(30),
            new ThreadFactoryBuilder().setNameFormat("xxx-")
                    .setUncaughtExceptionHandler((t, e) -> {

                    }).build(),
            new ThreadPoolExecutor.AbortPolicy());

    static class DemoCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
//            Thread.sleep(100);
            return "hello";
        }
    }

    public static void main(String[] args) {

        List<Future<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 70; i++) {
            Callable<String> callable = new DemoCallable();
            Future<String> f = null;
            try {
                f = EXECUTOR_SERVICE.submit(callable);
            } catch (RejectedExecutionException | NullPointerException e) {
                e.printStackTrace();
            }
            if (f != null) {
                futures.add(f);
            }
        }
        for (Future<String> future : futures) {
            try {
                String res = future.get();
                System.out.println(res);
                System.out.println(EXECUTOR_SERVICE.toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--------------");
        EXECUTOR_SERVICE.shutdown();
    }
}
