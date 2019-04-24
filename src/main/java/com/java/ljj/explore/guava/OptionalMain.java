package com.java.ljj.explore.guava;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalMain {

    public static void main(String[] args) {
        Optional<String> s = Optional.ofNullable("xx");
//        s.ifPresentOrElse(String::new, () -> {
//            System.out.println("hello world");
//        });
        s.ifPresent(s1 -> {
            System.out.println("xxxx");
        });
        String res = s.orElseThrow();
        System.out.println(res);
    }
}
