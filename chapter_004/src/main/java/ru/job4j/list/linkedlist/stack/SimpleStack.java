package ru.job4j.list.linkedlist.stack;

import ru.job4j.list.linkedlist.PlainLinkedList;

public class SimpleStack<E> {

    private PlainLinkedList<E> linkedStore = new PlainLinkedList<>();

    /**
     * poll last element.
     * @return - element.
     */
    public E poll() {
        E result  = linkedStore.get(linkedStore.getLastIndexFromList());
        linkedStore.deleteLastElement();
        return result;
    }

    /**
     * "add" element to stack.
     * @param item - received element.
     */
    public void push(E item) {
        linkedStore.add(item);
    }

    /**
     * Getter.
     * @return - linkedStore.
     */
    public PlainLinkedList<E> getLinkedStore() {
        return linkedStore;
    }
}
