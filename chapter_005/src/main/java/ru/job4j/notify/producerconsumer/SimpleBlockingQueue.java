package ru.job4j.notify.producerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

@ThreadSafe
public class SimpleBlockingQueue<E> {

    private final Integer capacity;

    @GuardedBy("this")
    private volatile Queue<E> queue;

    public SimpleBlockingQueue(Integer capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void checkQueStatus(E value) throws InterruptedException {
        if (queue.size() == capacity || value == null) {
            System.out.println(Thread.currentThread().getName() + " лег спать");
            wait();
        } else if (queue.size() < capacity) {
            notify();

        }
    }

    public synchronized void offer(E element) throws InterruptedException {
        queue.offer(element);
        System.out.println(Thread.currentThread().getName() + " Producer добавил элемент:" + element);
    }

    public synchronized E poll() {
        if (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object object = queue.poll();
        notifyAll();
        System.out.println("команда разбудить");
        System.out.println("Объект " + object + " из очереди извлечён");
        return (E) object;
    }
}
