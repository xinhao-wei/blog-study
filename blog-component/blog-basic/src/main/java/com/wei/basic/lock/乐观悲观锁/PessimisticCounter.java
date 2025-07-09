package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PessimisticCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    
    public void increment() {
        lock.lock();  // 获取锁
        try {
            count++;
            System.out.println("悲观锁计数: " + count);
            Thread.sleep(10);  // 模拟处理时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  // 释放锁
        }
    }
    
    public int getCount() {
        return count;
    }
}