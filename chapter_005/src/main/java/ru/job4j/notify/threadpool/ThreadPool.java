package ru.job4j.notify.threadpool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ThreadPool {
    @GuardedBy("this")
    protected volatile static boolean isWorking = true;

    private final List<Thread> threads;

    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        this.threads = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            threads.add(new WorkingThreads(tasks));
        }

        for (int i = 0; i < size; i++) {
            threads.get(i).start();
        }

    }


    public synchronized void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        isWorking = false;
    }

}

