package ru.job4j.notify.simpleque;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<E> {

    @GuardedBy("this")
    private Queue<E> queue = new LinkedList<>();

    public synchronized void offer(E value) {
        queue.offer(value);
    }

    public synchronized E poll() {
        if (queue.poll() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }

}
