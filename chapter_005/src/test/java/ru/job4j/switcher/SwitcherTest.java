package ru.job4j.switcher;

import org.junit.Test;
import ru.job4j.switcher.mutal.Mutual;
import ru.job4j.switcher.mutal.MutualString;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class SwitcherTest {

    ExecutorService executorService;
    private final Mutual<String> mutualString = new MutualString("");

    @Test
    public void whenTwoThreadsAreWorkingWithSameObject() throws ExecutionException, InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Switcher firstSwitcher = new Switcher(mutualString, 10, 1);
        Switcher secondSwitcher = new Switcher(mutualString, 10, 2);
        executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            while (Thread.currentThread().isAlive()) {
                executorService.submit(firstSwitcher);
                executorService.submit(secondSwitcher);
            }
        });
        executorService.wait(2000);
        executorService.shutdown();

    }
}
