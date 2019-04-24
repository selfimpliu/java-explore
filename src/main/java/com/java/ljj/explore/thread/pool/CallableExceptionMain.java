package com.java.ljj.explore.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExceptionMain {

    static class ThrowRuntimeExceptionCallable implements Callable<String> {

        private boolean isThrow() {
            return true;
        }

        @Override
        public String call() throws Exception {
            if (isThrow()) {
                throw new RuntimeException("test throw runtime exception");
            }
            return null;
        }
    }

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        Future<String> future = POOL.submit(new ThrowRuntimeExceptionCallable());

        String res = future.get();

        System.out.println(res);
    }
}
