package com.wei.basic.lock.锁升级;

import org.openjdk.jol.info.ClassLayout;

/**
 * 无锁测试类
 */
public class NoLock {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("无锁状态:\n" + ClassLayout.parseInstance(lock).toPrintable());
    }
}
