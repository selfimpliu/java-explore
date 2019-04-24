package com.java.ljj.explore.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExceptionMain {

    static class ThrowRuntimeExceptionRunnable implements Runnable {
        private boolean isThrow;

        public ThrowRuntimeExceptionRunnable(boolean isThrow) {
            this.isThrow = isThrow;
        }

        @Override
        public void run() {
            if (isThrow) {
                throw new RuntimeException("test throw run time exception in runnable");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        }
    }

    private static final ExecutorService POOL = Executors.newFixedThreadPool(11);

    public static void main(String[] args) {
        POOL.execute(new ThrowRuntimeExceptionRunnable(true));
        POOL.execute(new ThrowRuntimeExceptionRunnable(false));

        POOL.shutdown();
    }
}
