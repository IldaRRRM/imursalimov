package ru.job4j.pools.simplelock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLock {

    private final Lock simpleLock = new ReentrantLock();

    public void lock() {
        simpleLock.lock();
    }

    public void unlock() {
        simpleLock.unlock();
    }
}
