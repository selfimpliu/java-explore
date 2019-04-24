package com.java.ljj.explore.guava;

import com.google.common.cache.*;
import lombok.Data;

import java.util.concurrent.TimeUnit;

public class GuavaCacheMain {

    @Data
    static class Student {
        private Long id;
        private String name;
    }

    private static Student loadFromDb(String key) {
        return new Student();
    }

    public static void main(String[] args) {
        LoadingCache<String, Student> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .concurrencyLevel(100)
                .removalListener(new RemovalListener<String, Student>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Student> removalNotification) {

                    }
                })
                .build(
                        new CacheLoader<String, Student>() {
                            @Override
                            public Student load(String s) throws Exception {
                                return loadFromDb(s);
                            }
                        }
                );
    }
}
