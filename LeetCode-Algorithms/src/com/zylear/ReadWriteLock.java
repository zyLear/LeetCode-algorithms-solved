package com.zylear;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ReadWriteLock {

    public static class Sync extends AbstractQueuedSynchronizer {

        static final int SHARED_SHIFT = 16;
        static final int SHARED_UNIT = (1 << SHARED_SHIFT);
        static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

        ThreadLocal<Integer> readLockCountHolder = new ThreadLocal<>();

        static int sharedCount(int c) {
            return c >>> SHARED_SHIFT;
        }

        static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }


        @Override
        protected int tryAcquireShared(int arg) {
            Thread current = Thread.currentThread();

            while (true) {
                int c = getState();
                if (exclusiveCount(c) != 0) {
                    if (getExclusiveOwnerThread() != current)
                        return -1;
                } else if (hasQueuedPredecessors()) {
                    Integer lockEnterCount = readLockCountHolder.get();
                    if (lockEnterCount == null || lockEnterCount == 0) {
                        return -1;
                    }
                }

                if (sharedCount(c) == MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
                if (compareAndSetState(c, c + SHARED_UNIT)) {
                    Integer lockEnterCount = readLockCountHolder.get();
                    if (lockEnterCount == null) {
                        lockEnterCount = 0;
                    }
                    lockEnterCount++;
                    readLockCountHolder.set(lockEnterCount);
                    return 1;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {

            Integer count = readLockCountHolder.get();
            if (count == null || count == 0) {
                throw new RuntimeException("current thread don't hold read lock");
            }
            if (count == 1) {
                readLockCountHolder.remove();
            } else {
                count--;
                readLockCountHolder.set(count);
            }

            while (true) {
                int c = getState();
                int nextc = c - SHARED_UNIT;
                if (compareAndSetState(c, nextc))
                    return nextc == 0;
            }
        }

        @Override
        protected boolean tryAcquire(int acquires) {

            Thread current = Thread.currentThread();
            int c = getState();
            int w = exclusiveCount(c);
            if (c != 0) {
                // 有获取了读锁或者获取写锁不是当前线程
                if (w == 0 || current != getExclusiveOwnerThread()) {
                    return false;
                }
                if (w + exclusiveCount(acquires) > MAX_COUNT) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(c + acquires);
                return true;
            }
            if (hasQueuedPredecessors() ||
                    !compareAndSetState(c, c + acquires)) {
                return false;
            }
            setExclusiveOwnerThread(current);
            return true;

        }

        @Override
        protected boolean tryRelease(int releases) {
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
            if (free) {
                setExclusiveOwnerThread(null);
            }
            setState(nextc);
            return free;
        }

        @Override
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }

    private Sync sync;

    public ReadWriteLock() {
        this.sync = new Sync();
    }

    public void readLock() {
        sync.acquireShared(1);
    }

    public void readUnlock() {
        sync.releaseShared(1);
    }

    public void writeLock() {
        sync.acquire(1);
    }

    public void writeUnlock() {
        sync.release(1);
    }

}
