package com.wei.basic.lock.重入锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xinhao
 * @Date 2025/7/10 14:08
 */
public class Test {

    static ReentrantLock lock = new ReentrantLock();

    static void recursiveMethod(int level) {
        lock.lock();  // 可重入获取
        try {
            System.out.println("进入层级: " + level);
            if (level > 0) {
                recursiveMethod(level - 1);  // 递归调用
            }
        } finally {
            lock.unlock();  // 必须匹配解锁
        }
    }

    public static void main(String[] args) {
        recursiveMethod(3);
    }
}
