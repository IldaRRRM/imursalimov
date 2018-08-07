package ru.job4j.notify.producerconsumer;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> bothSimpleBlocking = new SimpleBlockingQueue<>(3);

//    @Test
    public void testProducer() throws InterruptedException {
        // producers
        Producer producer = new Producer(bothSimpleBlocking);
        producer.enterToQue(10);
        producer.enterToQue(11);
        producer.enterToQue(12);
        producer.enterToQue(13);
        producer.enterToQue(14);
        producer.enterToQue(15);
        producer.enterToQue(16);
        Consumer consumer = new Consumer(bothSimpleBlocking);
        Thread producerThread = new Thread(producer);
        Thread consThread = new Thread(consumer);
        producerThread.start();
        consThread.start();
        producerThread.join();
        Thread.sleep(5000);
        consThread.interrupt();
        assertThat(consumer.getObjectsFromQue().size(), is(7));
    }


}