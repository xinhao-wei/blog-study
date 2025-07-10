package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticCounter {
    private final AtomicInteger count = new AtomicInteger(0);
    
    public void increment() {
        int oldValue, newValue;
        boolean compareAndSet;
        do {
            oldValue = count.get();
            newValue = oldValue + 1;
            // 模拟处理时间
            try { Thread.sleep(10); } catch (InterruptedException e) {}

            compareAndSet = count.compareAndSet(oldValue, newValue);
            if (!compareAndSet){
                System.out.println("触发冲突重试");
            }
        } while (!compareAndSet);
        System.out.println("乐观锁计数: " + newValue);
    }
    
    public int getCount() {
        return count.get();
    }
}