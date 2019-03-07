package com.java.ljj.explore.test;

public class B extends A {
    private int b = 1;
    private int a = 1;

    private void printB() {
        System.out.println(b);
    }

    public static void main(String[] args) {
        A a = new B();
        a.printA();
    }
}
