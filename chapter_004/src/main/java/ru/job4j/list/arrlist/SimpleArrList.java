package ru.job4j.list.arrlist;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.Container;

import java.util.*;
@ThreadSafe
public class SimpleArrList<E> implements Container<E> {

    @GuardedBy("this")
    private volatile Object[] container = new Object[10];
    private volatile int index = 0;
    private volatile int modCount = 0;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int iterInd = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return iterInd < index;
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
     * @param model - received model.
     */
    @Override
    public synchronized void add(E model) {
        container[index++] = model;
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
    public synchronized E get(int index) {
        return (E) container[index];
    }

    /**
     * array.
     * @return - array.
     */
    public synchronized Object[] getContainer() {
        return container;
    }
}
