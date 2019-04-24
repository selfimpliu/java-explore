package com.java.ljj.explore.thread;

public class TurnPrintDemo {

    private static volatile Integer TURN = 1;
    private static final Integer LOCK = 1;

    static class PrintOne implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (LOCK) {
                        while (TURN.equals(2)) {
                            System.out.println("turn is : 2, print One thread wait");
                            LOCK.wait();
                        }
                        System.out.println("print -------- 1");
                        Thread.sleep(1000);
                        TURN = 2;
                        LOCK.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class PrintTwo implements Runnable {
        @Override
        public void run() {
            try {

                while (true) {
                    synchronized (LOCK) {
                        while (TURN.equals(1)) {
                            System.out.println("turn is : 1, print Two thread wait");
                            LOCK.wait();
                        }
                        System.out.println("print -------- 2");
                        Thread.sleep(1000);
                        TURN = 1;
                        LOCK.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread printOneThread = new Thread(new PrintOne());
        printOneThread.setName("printOne-Thread");
        Thread printTwoThread = new Thread(new PrintTwo());
        printTwoThread.setName("printTwo-Thread");
        printOneThread.start();
        printTwoThread.start();

        printOneThread.join();
        printTwoThread.join();
    }
}
