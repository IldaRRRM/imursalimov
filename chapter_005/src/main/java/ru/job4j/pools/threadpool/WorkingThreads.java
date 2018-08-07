package ru.job4j.pools.threadpool;

import java.util.Queue;


public class WorkingThreads extends Thread {


    private final Queue<Runnable> tasks;

    public WorkingThreads(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Runnable runnable = tasks.poll();
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
