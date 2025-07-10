package com.wei.basic.lock.共享;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author xinhao
 * @Date 2025/7/10 15:20
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        SharedLock sharedLock = new SharedLock();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 进行写操作
        executor.execute(() -> sharedLock.writeData(3));

        // 进行读操作
        executor.execute(() -> {
            int i = sharedLock.readData();
            System.out.println(i);
        });
        // 进行读操作
        executor.execute(() -> {
            int i = sharedLock.readData();
            System.out.println(i);
        });


        // 进行写操作
        executor.execute(() -> sharedLock.writeData(4));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }
}
