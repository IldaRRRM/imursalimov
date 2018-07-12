package ru.job4j.notify.producerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

@ThreadSafe
public class Producer<E> implements Runnable {

    private final Queue<Object> que;

    @GuardedBy("this")
    private final SimpleBlockingQueue blockingQueue;


    public Producer(SimpleBlockingQueue recieved) {
        this.blockingQueue = recieved;
        this.que = new LinkedList<>();
    }

    public synchronized void enterToQue(E element) {
        que.add(element);
    }

    @Override
    public void run() {
        while (que.size() != 0) {
            try {
                blockingQueue.checkQueStatus(que.peek());
                blockingQueue.offer(que.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

