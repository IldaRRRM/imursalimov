package ru.job4j.list.linkedlist.stack;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    @Test
    public void pushSomeElementToOurStack() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(4);
        simpleStack.push(5);
        assertThat(simpleStack.getLinkedStore().get(1), is(5));
    }

    @Test
    public void pollMethodTestingFromSimpleStack() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

}