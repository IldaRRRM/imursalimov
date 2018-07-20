package ru.job4j.notify.threadpool;

import java.util.Queue;

import static ru.job4j.notify.threadpool.ThreadPool.isWorking;

public class WorkingThreads extends Thread {


    private final Queue<Runnable> tasks;

    public WorkingThreads(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (isWorking) {
            Runnable runnable = tasks.poll();
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
