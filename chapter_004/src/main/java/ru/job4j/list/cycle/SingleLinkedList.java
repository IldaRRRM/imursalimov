package ru.job4j.list.cycle;

import ru.job4j.list.Container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Container<E> {

    private int index = 0;

    private int modcount = 0;

    private Node<E> first;

    private Node<E> last;


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modcount;
            E result;
            Node<E> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                if (current != null) {
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
     * inner class.
     * @param <E> - generic.
     */
         class Node<E> {
        E element;
        Node<E> next;

        /**
         * @param element - received element.
         */
        Node(E element) {
            this.element = element;
        }
    }

    /**
     * add to LinkedList.
     * @param model - received param.
     */
    @Override
    public void add(E model) {
        Node<E> node = new Node<>(model);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        index++;
        modcount++;
    }

    /**
     * get element from list.
     * @param index - index.
     * @return - return element.
     */
    @Override
    public E get(int index) {
        Iterator<E> eIterator = iterator();
        E result = null;
        if (index > this.index - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < this.index; i++) {
                result = eIterator.next();
                if (i == index) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param singleLinkedList - received linkedList.
     * @return - boolean result of question: Is there a cycle?
     */
    public boolean hasCycle(SingleLinkedList<E> singleLinkedList) {

        Node<E> slow = singleLinkedList.first;

        Node<E> fast = singleLinkedList.first.next;

        if (singleLinkedList.first == null) {
            return false;
        }

        while (fast != null && fast.next != null || slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = (fast != null ? fast.next : null) != null ? fast.next.next : null;
        }
        return false;
    }

    /**
     *
     * @return - first Node.
     */
    public Node<E> getFirst() {
        return first;
    }

    /**
     *
     * @return - Last Node.
     */
    public Node<E> getLast() {
        return last;
    }
}
