package com.wei.basic.lock.锁升级;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁测试类
 */
public class BiasLock {

    public static void main(String[] args) throws InterruptedException {
        // 睡眠 5s
        Thread.sleep(5000);
        Object lock = new Object();
        System.out.println("未进入同步块，MarkWord 为：");
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock) {
            System.out.println("进入同步块，MarkWord 为：");
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
