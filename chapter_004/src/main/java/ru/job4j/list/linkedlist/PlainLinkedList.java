package ru.job4j.list.linkedlist;

import ru.job4j.list.Container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * PlainLinked - simple linkedList.
 *
 * @param <E> - generic.
 */
public class PlainLinkedList<E> implements Container<E> {

    private int index = 0;

    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    /**
     * @param <E> - generic.
     */
    class Node<E> {

        E element;

        Node<E> next;

        Node<E> previus;

        Node(E element) {
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
    public void add(E model) {
        Node<E> eNode = new Node<>(model);
        if (first == null) {
            first = eNode;
            first.next = eNode;
            last = eNode;
            last.previus = first;
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
    public E get(int index) {
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
    public void deleteLastElement() {
        last = last.previus;
        last.next = null;
        index--;

    }

    /**
     * delete first element.
     */
    public void removeFirstElement() {
        first = first.next;
        first.previus = null;
        index--;
    }

    /**
     * getter.
     *
     * @return - current value of index.
     */
    public int getLastIndexFromList() {
        return index - 1;
    }
}
