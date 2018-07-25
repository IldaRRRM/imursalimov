package ru.job4j.notify.simplelock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLockTest {

    private SimpleLock lock = new SimpleLock();

    private volatile int i = 0;

    @Test
    public void whenWeAreLockingThread() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i < 12) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        i++;

                    }
                } finally {
                    lock.unlock();
                }
//                System.out.println(i);
            }
        });
//        new SimpleLock(thread).lock();


        Thread secondthread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i < 19) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        i++;

                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (i < 19) {
                    i += 10;
                    System.out.println("yes");
                }
            }
        });

        thread.start();
        secondthread.start();
        secondthread.join();
        thread3.start();
        thread3.join();

        assertThat(i, is(19));
    }
}