package com.wei.basic.lock.重入锁;

public class NonReentrantLock {
    private boolean isLocked = false;
    private Thread lockingThread;
    
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
    }
    
    public synchronized void unlock() {
        if (Thread.currentThread() == lockingThread) {
            isLocked = false;
            lockingThread = null;
            notify();
        }
    }
}