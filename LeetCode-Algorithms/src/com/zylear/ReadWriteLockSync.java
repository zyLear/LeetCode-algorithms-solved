package com.zylear;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockSync {

    /**
     * 已经获取读锁的线程
     */
    private ConcurrentHashMap<Thread, Integer> currentOccupyReadLockThreads =
            new ConcurrentHashMap<>();
    /**
     * 写锁等待数量
     */
    private int writeLockWaitCount = 0;
    /**
     * 已经获取写锁的线程
     */
    private Thread currentOccupyWriteThread = null;
    /**
     * 获取写锁的线程进入写锁次数（重入功能）
     */
    private int writeLockEnterCount = 0;

    private volatile AtomicInteger status;

    private int READ = 1;

    /**
     * 获取读锁
     *
     * @throws InterruptedException
     */
    public void readLock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        boolean succ =false;
        int retryCount = 3;
        while (!succ) {
            retryCount--;
            if (retryCount < 0) {
                throw new RuntimeException("get readLock fail");
            }
            int oldStatus = status.get();
            if (oldStatus == 0 || oldStatus == 1) {
                succ = status.compareAndSet(oldStatus, READ);
                if (succ) {

                    //
                    Integer count = currentOccupyReadLockThreads.computeIfAbsent(currentThread, k -> 0);
                    currentOccupyReadLockThreads.put(currentThread, count + 1);

                }
            }

            java.util.concurrent.locks.ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
            Lock writeLock = readWriteLock.writeLock();
            Lock lock = readWriteLock.readLock();
            readWriteLock.writeLock();
            lock.lock();
            writeLock.lock();

        }



        while (!canRequestReadLock(currentThread) ) {
            retryCount--;
            if (retryCount < 0) {
                throw new RuntimeException("get readLock fail");
            }
            wait();
        }
        Integer count = currentOccupyReadLockThreads.computeIfAbsent(currentThread, k -> 0);
        currentOccupyReadLockThreads.put(currentThread, count + 1);
    }

    /**
     * 判断当前线程是否可以获取读锁
     *
     * @param currentThread
     * @return
     */
    private boolean canRequestReadLock(Thread currentThread) {
        if (currentOccupyWriteThread == currentThread) {
            return true;
        }
        if (currentOccupyWriteThread != null) {
            return false;
        }
        if (currentOccupyReadLockThreads.containsKey(currentThread)) {
            return true;
        }
        if (writeLockWaitCount > 0) {
            return false;
        }
        return true;
    }

    /**
     * 释放读锁
     */
    public void readUnlock() {
        Thread currentThread = Thread.currentThread();
        if (!currentOccupyReadLockThreads.containsKey(currentThread)) {
            throw new RuntimeException("current thread don't hold read lock");
        }


        int enterLockCount = currentOccupyReadLockThreads.get(currentThread);
        if (enterLockCount == 1) {
            currentOccupyReadLockThreads.remove(currentThread);
        } else {
            currentOccupyReadLockThreads.put(currentThread, (enterLockCount - 1));
        }
        //通知等待的线程
//        notifyAll();
    }

    /**
     * 获取写锁
     *
     * @throws InterruptedException
     */
    public synchronized void writeLock() throws InterruptedException {
        writeLockWaitCount++;
        Thread currentThread = Thread.currentThread();
        while (!canRequestWriteLock(currentThread)) {
            wait();
        }
        writeLockEnterCount++;
        writeLockWaitCount--;
        currentOccupyWriteThread = currentThread;
    }

    /**
     * 释放写锁
     */
    public synchronized void writeUnlock() {
        Thread currentThread = Thread.currentThread();
        if (currentOccupyWriteThread != currentThread) {
            throw new RuntimeException("current thread don't hold write lock");
        }
        writeLockEnterCount--;
        if (writeLockEnterCount == 0) {
            currentOccupyWriteThread = null;
        }
        //通知等待的线程
        notifyAll();
    }

    /**
     * 判断当前线程是否可以获取写锁
     *
     * @param currentThread
     * @return
     */
    private boolean canRequestWriteLock(Thread currentThread) {
        if (currentOccupyReadLockThreads.size() == 1 &&
                currentOccupyReadLockThreads.containsKey(currentThread)) {
            return true;
        }
        if (currentOccupyReadLockThreads.size() > 0) {
            return false;
        }
        if (currentOccupyWriteThread == null) {
            return true;
        }
        if (currentOccupyWriteThread != currentThread) {
            return false;
        }
        return true;
    }

}
