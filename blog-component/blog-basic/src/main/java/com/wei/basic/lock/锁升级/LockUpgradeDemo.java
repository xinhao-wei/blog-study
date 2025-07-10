package com.wei.basic.lock.锁升级;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class LockUpgradeDemo {
    private static final Object lock = new Object();
 
    public static void main(String[] args) throws InterruptedException {
        System.out.println("无锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());
        Thread.sleep(5000); // 确保 Thread1 执行完
        // 阶段 1：偏向锁（线程 A 首次访问）
        new Thread(() -> {
            synchronized (lock) {
                log.info("Thread1: 获取偏向锁");
                while (true) {

                }
            }
        }).start();
        Thread.sleep(1000); // 确保 Thread1 执行完
        log.info("偏向锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());



//        // 阶段 2：轻量级锁（线程 B 竞争）
//        new Thread(() -> {
//            synchronized (lock) {
//                log.info("Thread2: 升级为轻量级锁");
//            }
//        }).start();
//        Thread.sleep(500);
//        log.info("轻量级锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());


//        // 阶段 3：重量级锁（多个线程高竞争）
//        for (int i = 0; i < 5; i++) {
//            final int index = i;
//            new Thread(() -> {
//                synchronized (lock) {
//                    log.info("Thread" + index + ": 升级为重量级锁");
//                }
//            }).start();
//        }
//
//        System.out.println("重量级锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());
    }
}