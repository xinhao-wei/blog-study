package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConflictVisualization {
    private AtomicInteger optimisticConflicts = new AtomicInteger(0);
    private int pessimisticBlocks = 0;
    private final Lock lock = new ReentrantLock();
    
    // 乐观锁版本
    public void optimisticIncrement() {
        int conflicts = 0;
        int oldValue, newValue;
        do {
            oldValue = optimisticConflicts.get();
            newValue = oldValue + 1;
            conflicts++;
        } while (!optimisticConflicts.compareAndSet(oldValue, newValue));
        System.out.println("乐观锁冲突次数: " + conflicts);
    }
    
    // 悲观锁版本
    public void pessimisticIncrement() {
        int waitCount = 0;
        while (!lock.tryLock()) {
            waitCount++;
            try { Thread.sleep(1); } catch (InterruptedException e) {}
        }
        try {
            pessimisticBlocks++;
            System.out.println("悲观锁等待次数: " + waitCount);
        } finally {
            lock.unlock();
        }
    }
}