package com.wei.basic.lock.锁升级;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 轻量级锁测试类
 */
public class LightWeightLock {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Thread.sleep(5000); // 确保 启用偏向锁
        Object lock = new Object();

        // 阶段 1：偏向锁（线程 A 首次访问）
        executor.execute(() -> {
            synchronized (lock) {
                System.out.println("Thread1: 获取偏向锁");
            }
        });

        // 阶段 2：轻量级锁（线程 B 竞争）
        executor.execute(() -> {
            synchronized (lock) {
                System.out.println("Thread2: 升级为轻量级锁");
                System.out.println("轻量级锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());
            }
        });

    }
}
