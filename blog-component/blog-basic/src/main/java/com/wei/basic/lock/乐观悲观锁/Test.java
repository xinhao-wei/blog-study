package com.wei.basic.lock.乐观悲观锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author xinhao
 * @Date 2025/7/9 17:07
 */
public class Test {
    public static void main(String[] args) {
        PessimisticCounter test = new PessimisticCounter();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executor.execute(test::increment);
            executor.execute(test::increment);
        }
        executor.shutdown();
    }
}
