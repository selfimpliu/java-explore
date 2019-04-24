package com.java.ljj.explore.thread.queue;


import com.google.common.collect.Lists;

import java.util.List;

public class DemoBlockingQueue implements JJLBlockingQueue {

    private List<Integer> list = Lists.newArrayList();
    private final int size = 10;

    private void enqueue(int ele) {
        list.add(ele);
    }

    private int dequeue() {
        return list.remove(0);
    }

    private boolean isFull() {
        return list.size() == size;
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void put(int ele) throws InterruptedException {
        synchronized (list) {
            while (isFull()) {
                list.wait();
            }
            enqueue(ele);
            list.notifyAll();
            System.out.println(list);
        }
    }

    @Override
    public int take() throws InterruptedException {
        synchronized (list) {
            while (isEmpty()) {
                list.wait();
            }
            int res = dequeue();
            list.notifyAll();
            return res;
        }
    }
}
