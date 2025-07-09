package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticCounter {
    private AtomicInteger count = new AtomicInteger(0);
    
    public void increment() {
        int oldValue, newValue;
        do {
            oldValue = count.get();
            newValue = oldValue + 1;
            // 模拟处理时间
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        } while (!count.compareAndSet(oldValue, newValue));
        System.out.println("乐观锁计数: " + newValue);
    }
    
    public int getCount() {
        return count.get();
    }
}