package ru.job4j.notify.producerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class Consumer implements Runnable {
    private volatile List<Object> objectsFromQue;

    @GuardedBy("this")
    private volatile SimpleBlockingQueue simpleBlockingQueue;

    public Consumer(SimpleBlockingQueue bothSimpleBlocking) {
        this.simpleBlockingQueue = bothSimpleBlocking;
        this.objectsFromQue = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            Object object = simpleBlockingQueue.poll();
            objectsFromQue.add(object);
            System.out.println("добавлен " + object);
        }
    }

    public List<Object> getObjectsFromQue() {
        return objectsFromQue;
    }
}
