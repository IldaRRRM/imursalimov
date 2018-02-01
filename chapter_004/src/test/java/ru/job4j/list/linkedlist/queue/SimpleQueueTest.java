package ru.job4j.list.linkedlist.queue;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
    @Test
    public void pushSomeElementToOurStack() {
        SimpleQueue<Integer> simpleStack = new SimpleQueue<>();
        simpleStack.push(4);
        simpleStack.push(5);
        assertThat(simpleStack.getLinkedStore().get(1), is(5));
    }

    @Test
    public void pollMethodTestingFromSimpleStack() {
        SimpleQueue<String> simpleStack = new SimpleQueue<>();
        simpleStack.push("First");
        simpleStack.push("Second");
        simpleStack.push("Third");
        simpleStack.push("Fourth");
        assertThat(simpleStack.poll(), is("First"));
        assertThat(simpleStack.poll(), is("Second"));
        assertThat(simpleStack.poll(), is("Third"));
        assertThat(simpleStack.poll(), is("Fourth"));
        //
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}