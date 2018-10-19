package ru.job4j.switcher;

import org.junit.Test;
import ru.job4j.switcher.executor.SwitcherFutureTaskExecutor;
import ru.job4j.switcher.mutal.Mutual;
import ru.job4j.switcher.mutal.MutualString;
import ru.job4j.switcher.priority.Priority;
import ru.job4j.switcher.switcherfuturetask.Switcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class SwitcherTest {

    private final Mutual<String> mutualString = new MutualString("");
    private final PriorityBlockingQueue queue = new PriorityBlockingQueue();
    private ThreadPoolExecutor executor;

    @Test
    public void whenTwoThreadsAreWorkingWithSameStringObject() throws ExecutionException, InterruptedException {

        executor = new ThreadPoolExecutor(0, 2, 1000, TimeUnit.MILLISECONDS, queue);

        SwitcherFutureTaskExecutor futureTaskExecutor = new SwitcherFutureTaskExecutor(executor, queue);

        Switcher highPriorityTask = new Switcher(mutualString, 10, 1, Priority.FIRST);
        Switcher lowPriorityTask = new Switcher(mutualString, 10, 2, Priority.SECOND);

        List<Switcher> listWithOnlyTwoSwitchers = new ArrayList<>();

        listWithOnlyTwoSwitchers.add(highPriorityTask);
        listWithOnlyTwoSwitchers.add(lowPriorityTask);

        Thread executorThreadForTwoThreads = futureTaskExecutor.executorThreadWithLists(listWithOnlyTwoSwitchers);

        executorThreadForTwoThreads.start();

        executorThreadForTwoThreads.join(3000);

        executorThreadForTwoThreads.interrupt();

    }

    @Test
    public void whenFiveThreadsWorkingWithSameObject() throws ExecutionException, InterruptedException {

        executor = new ThreadPoolExecutor(0, 2, 1000, TimeUnit.MILLISECONDS, queue);

        SwitcherFutureTaskExecutor futureTaskExecutor = new SwitcherFutureTaskExecutor(executor, queue);

        Switcher firstPriorityTask = new Switcher(mutualString, 10, 1, Priority.FIRST);
        Switcher secondPriority = new Switcher(mutualString, 10, 2, Priority.SECOND);
        Switcher thirdPriority = new Switcher(mutualString, 10, 3, Priority.THIRD);
        Switcher fourthPriority = new Switcher(mutualString, 10, 4, Priority.FOURTH);
        Switcher fivePriority = new Switcher(mutualString, 10, 5, Priority.FITH);

        List<Switcher> switchers = new ArrayList<>();

        switchers.add(fivePriority);
        switchers.add(thirdPriority);
        switchers.add(secondPriority);
        switchers.add(firstPriorityTask);
        switchers.add(fourthPriority);

        Thread executorThreadForTwoThreads = futureTaskExecutor.executorThreadWithLists(switchers);

        executorThreadForTwoThreads.start();

        executorThreadForTwoThreads.join(3000);

        executorThreadForTwoThreads.interrupt();

    }


    @Test
    public void whenThreadsHaveSamePriority() throws ExecutionException, InterruptedException {

        executor = new ThreadPoolExecutor(0, 2, 1000, TimeUnit.MILLISECONDS, queue);

        SwitcherFutureTaskExecutor futureTaskExecutor = new SwitcherFutureTaskExecutor(executor, queue);
        //Будет борьба между первым и вторыми потоками, поток, с приоритетом 2 всегда будет последним
        Switcher firstPriorityTask = new Switcher(mutualString, 10, 1, Priority.FIRST);
        Switcher secondPriority = new Switcher(mutualString, 10, 2, Priority.FIRST);
        Switcher fourthPriority = new Switcher(mutualString, 10, 4, Priority.SECOND);

        List<Switcher> switchers = new ArrayList<>();

        switchers.add(secondPriority);
        switchers.add(firstPriorityTask);
        switchers.add(fourthPriority);

        Thread executorThreadForTwoThreads = futureTaskExecutor.executorThreadWithLists(switchers);

        executorThreadForTwoThreads.start();

        executorThreadForTwoThreads.join(3000);

        executorThreadForTwoThreads.interrupt();

    }

}


