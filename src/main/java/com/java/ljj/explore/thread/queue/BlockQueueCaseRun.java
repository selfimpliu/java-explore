package com.java.ljj.explore.thread.queue;

public class BlockQueueCaseRun {

    static class Producer implements Runnable {
        private JJLBlockingQueue queue;
        private int i;

        public Producer(JJLBlockingQueue queue, int i) {
            this.queue = queue;
            this.i = i;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    queue.put(i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private JJLBlockingQueue queue;

        public Consumer(JJLBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int res = queue.take();
                    System.out.println(res);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            DemoBlockingQueue queue = new DemoBlockingQueue();
//            JJLBlockingQueue queue = new DemoLockBlockQueue();

            Thread producerThread = new Thread(new Producer(queue, 0));
            Thread producerThread1 = new Thread(new Producer(queue, 100));
            Thread consumerThread = new Thread(new Consumer(queue));

            producerThread.start();
            producerThread1.start();
            consumerThread.start();

            producerThread.join();
            producerThread1.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
