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
    }
}