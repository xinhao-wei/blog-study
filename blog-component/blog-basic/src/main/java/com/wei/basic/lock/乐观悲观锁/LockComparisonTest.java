package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockComparisonTest {
    public static void testPessimistic(int threadCount) throws InterruptedException {
        PessimisticCounter counter = new PessimisticCounter();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            executor.execute(counter::increment);
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("悲观锁最终计数: " + counter.getCount() + 
                         ", 耗时: " + (System.currentTimeMillis() - start) + "ms");
    }
    
    public static void testOptimistic(int threadCount) throws InterruptedException {
        OptimisticCounter counter = new OptimisticCounter();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            executor.execute(counter::increment);
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("乐观锁最终计数: " + counter.getCount() + 
                         ", 耗时: " + (System.currentTimeMillis() - start) + "ms");
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 低并发场景(5线程) ===");
        testPessimistic(5);
        testOptimistic(5);
        
        System.out.println("\n=== 高并发场景(50线程) ===");
        testPessimistic(50);
        testOptimistic(50);
    }
}