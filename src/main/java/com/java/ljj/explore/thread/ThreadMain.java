package com.java.ljj.explore.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

/**
 * @author liujingjun
 * @since 2019/4/20 下午2:52
 **/
public class ThreadMain {


    public static void main(String[] args) {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String s = format.format(new Date());
        System.out.println(s);

//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinPoolforkJoinPool.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "test";
//            }
//        });

    }
}
