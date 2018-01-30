package ru.job4j.list.linkedlist.queue;

import ru.job4j.list.linkedlist.PlainLinkedList;



public class SimpleQueue<E> {

    private PlainLinkedList<E> linkedStore = new PlainLinkedList<>();

    /**
     * @return - polled value.
     */
    public E poll() {
        E result = linkedStore.get(0);
        linkedStore.removeFirstElement();
        return result;
    }

    /**
     * push to our stack.
     * @param value - received value.
     */
    public void push(E value) {
        linkedStore.add(value);
    }

    /**
     * getter.
     * @return - linkedStore.
     */
    public PlainLinkedList<E> getLinkedStore() {
        return linkedStore;
    }
}

