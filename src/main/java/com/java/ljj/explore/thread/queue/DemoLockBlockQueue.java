package com.java.ljj.explore.thread.queue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoLockBlockQueue implements JJLBlockingQueue {
    private List<Integer> list = Lists.newArrayList();
    private final int size = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition emptyCondition = lock.newCondition();
    private final Condition fullCondition = lock.newCondition();

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
        lock.lock();
        try {
            while (isFull()) {
                fullCondition.await();
            }
            enqueue(ele);
            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (isEmpty()) {
                emptyCondition.await();
            }
            int res = dequeue();
            fullCondition.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }
}
