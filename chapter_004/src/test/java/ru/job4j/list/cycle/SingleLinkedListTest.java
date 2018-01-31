package ru.job4j.list.cycle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SingleLinkedListTest {
    @Test
    public void whenWeHaveACycleFromLastToFirstElement() {
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Fourth");
        linkedList.add("Five");
        linkedList.getLast().next = linkedList.getFirst();
        assertThat(linkedList.hasCycle(linkedList), is(true));
    }
    @Test
    public void cycleInListFromThirdToSecondElement() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.getFirst().next.next = linkedList.getFirst().next;
        assertThat(linkedList.hasCycle(linkedList), is(true));
    }

    @Test
    public void everythingIsAlrightAndResultMustBeAFalse() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(1);
        assertThat(linkedList.hasCycle(linkedList), is(false));
    }

}