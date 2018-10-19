package ru.job4j.switcher.executor;

import ru.job4j.switcher.switcherfuturetask.Switcher;
import ru.job4j.switcher.switcherfuturetask.SwitcherFuterTask;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SwitcherFutureTaskExecutor {

    private final ThreadPoolExecutor executor;
    private final PriorityBlockingQueue queue;


    public SwitcherFutureTaskExecutor(ThreadPoolExecutor executor, PriorityBlockingQueue queue) {
        this.executor = executor;
        this.queue = queue;
    }

    public Thread executorThreadWithLists(List<Switcher> switchers) {
        return new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                switchers.stream().map(SwitcherFuterTask::new).forEach(executor::execute);
                try {
                    executor.awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
    }

}
