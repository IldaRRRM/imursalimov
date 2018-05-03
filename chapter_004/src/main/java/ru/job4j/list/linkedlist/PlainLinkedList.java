package ru.job4j.list.linkedlist;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.Container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PlainLinked - simple linkedList.
 *
 * @param <E> - generic.
 */
@ThreadSafe
public class PlainLinkedList<E> implements Container<E> {
    @GuardedBy("this")
    private int index = 0;

    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    /**
     * @param <T> - generic.
     */
    class Node<T> {

        T element;

        Node<T> next;

        Node<T> previus;

        Node(T element) {
            this.element = element;
        }
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            Node<E> current = first;

            E result;

            int modCountExpected = modCount;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    if (modCountExpected != modCount) {
                        throw new ConcurrentModificationException();
                    }
                    result = current.element;
                    current = current.next;
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    /**
     * add for our linkedlist.
     *
     * @param model - received param.
     */
    @Override
    public synchronized void add(E model) {
        Node<E> eNode = new Node<>(model);
        if (first == null) {
            first = eNode;
        } else {
            last.next = eNode;
            eNode.previus = last;
        }
        last = eNode;
        index++;
        modCount++;
    }

    /**
     * @param index - with this index we'll get our object in list.
     * @return - object.
     */
    @Override
    public synchronized E get(int index) {
        if (index > this.index - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            E result = null;
            Iterator<E> eIterator = iterator();
            for (int i = 0; i < this.index; i++) {
                result = eIterator.next();
                if (i == index) {
                    break;
                }
            }
            return result;
        }
    }

    /**
     * delete last element from LinkedList.
     */
    public synchronized void deleteLastElement() {
        if (last.previus == null) {
            first = null;
            last = null;
            index = 0;
        } else {
            last = last.previus;
            last.next = null;
            index--;
        }
    }

    /**
     * delete first element.
     */
    public synchronized void removeFirstElement() {
        if (first.next == null) {
            first = null;
            index = 0;
        } else {
            first = first.next;
            first.previus = null;
            index--;
        }
    }

    /**
     * getter.
     *
     * @return - current value of index.
     */
    public synchronized int getLastIndexFromList() {
        return index - 1;
    }

    /**
     * getter for firstNode.
     *
     * @return
     */
    public synchronized Node<E> getFirst() {
        return first;
    }

    /**
     * getter for LastNode.
     *
     * @return - lastNode.
     */
    public synchronized Node<E> getLast() {
        return last;
    }
}
