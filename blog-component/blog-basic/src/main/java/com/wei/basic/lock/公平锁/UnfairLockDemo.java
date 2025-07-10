package com.wei.basic.lock.公平锁;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockDemo {
    private static final ReentrantLock unfairLock = new ReentrantLock(false);
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        // 创建并启动所有线程
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatch.await(); // 所有线程在此等待
                    unfairLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " 获取锁");
                        Thread.sleep(100); // 模拟工作
                    } finally {
                        unfairLock.unlock();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread-" + (i + 1)).start();
        }
        
        // 同时释放所有线程
        startLatch.countDown();
    }
}