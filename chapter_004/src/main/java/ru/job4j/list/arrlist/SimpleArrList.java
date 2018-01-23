package ru.job4j.list.arrlist;

import ru.job4j.list.Container;

import java.util.*;

public class SimpleArrList<E> implements Container<E> {

    private Object[] container = new Object[10];

    private int index = 0;
    private int iterInd = 0;
    private int size = 0;
    private int modCount = 0;

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iterInd + 1 <= size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (hasNext()) {
                    return (E) container[iterInd++];
                } else {
                    throw new NoSuchElementException("no such element exc");
                }
            }
        };
    }

    /**
     * add to container.
     *
     * @param model - received model.
     */
    @Override
    public void add(E model) {
        container[index++] = model;
        size++;
        modCount++;
        if (container.length == index + 1) {
            container = Arrays.copyOf(container, container.length + 1);
        }
    }

    /**
     * @param index - index.
     * @return - return E model.
     */
    @Override
    public E get(int index) {
        return (E) container[index];
    }

}
