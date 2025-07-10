package com.wei.basic.lock.共享;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class SharedLock {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int sharedData = 0;
    
    public void writeData(int value) {
        rwLock.writeLock().lock(); // 获取写锁(独占)
        try {
            log.info(Thread.currentThread().getName() + "获取到写锁");
            sharedData = value;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.info(Thread.currentThread().getName() + "释放写锁");
            rwLock.writeLock().unlock();
        }
    }
    
    public int readData() {
        rwLock.readLock().lock(); // 获取读锁(共享)
        try {
            log.info(Thread.currentThread().getName() + "获取到读锁");
            Thread.sleep(2000);
            return sharedData;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.info(Thread.currentThread().getName() + "释放读锁");
            rwLock.readLock().unlock();
        }
    }
}