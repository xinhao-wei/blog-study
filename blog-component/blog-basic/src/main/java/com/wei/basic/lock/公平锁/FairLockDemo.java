package com.wei.basic.lock.公平锁;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xinhao
 * @Date 2025/7/10 13:37
 */
public class FairLockDemo {
    private static final ReentrantLock fairLock = new ReentrantLock(true);
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatch.await();
                    fairLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "获取公平锁");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        fairLock.unlock();
                    }
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                }
            }).start();
            // 确保按顺序启动
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }

        // 同时释放所有线程
        startLatch.countDown();
    }
}
