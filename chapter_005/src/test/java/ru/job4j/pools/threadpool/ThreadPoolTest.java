package ru.job4j.pools.threadpool;

public class ThreadPoolTest {

//    @Test
    public void threadPoolTest() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        threadPool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Hello");
            }
        });

        threadPool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Hello from another thread");
            }
        });

        threadPool.work(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Hello from another thread");
            }
        });
        threadPool.work(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        break;
                    }
                    System.out.println(System.currentTimeMillis());
                }
            }
        });

        Thread.sleep(2000);

        threadPool.shutdown();

    }

}