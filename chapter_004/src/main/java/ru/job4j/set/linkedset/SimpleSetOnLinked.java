package ru.job4j.set.linkedset;

import ru.job4j.list.linkedlist.PlainLinkedList;

import java.util.Iterator;

public class SimpleSetOnLinked<E> extends PlainLinkedList<E> {
    /**
     * add method.
     * @param model - received param.
     */
    @Override
    public void add(E model) {
        boolean possible = true;

        Iterator<E> eIterator = iterator();

        if (getFirst() == null) {
            super.add(model);
        } else {
            while (eIterator.hasNext()) {
                if (eIterator.next().equals(model)) {
                    possible = false;
                }
            }
            if (possible) {
                super.add(model);
            }
        }
    }
}
