package com.wei.basic.lock.重入锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author xinhao
 * @Date 2025/7/10 14:31
 */
public class NonReentrantDemo {

    public static NonReentrantLock nonReentrantLock = new NonReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //for (int i = 0; i < 5; i++) {
        //    executorService.execute(NonReentrantDemo::testNoReentrantLock);
        //}

        executorService.execute(() -> {
            try {
                // 多次加锁
                nonReentrantLock.lock();
                System.out.println("第一次加锁成功");
                nonReentrantLock.lock();
                System.out.println("第二次加锁成功");
                // 开始释放锁
                nonReentrantLock.unlock();
                nonReentrantLock.unlock();
            } catch (Exception e) {
                System.out.println("加锁失败: " + e.getMessage());
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    public static void testNoReentrantLock() {
        try {
            nonReentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取锁");
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            nonReentrantLock.unlock();
        }
    }
}
