package ru.job4j.tree.binarysearchtree;

import java.util.*;


public class SimpleBinarySearchTree<E extends Comparable<E>> implements Iterable<E> {

    private Node<E> root;

    private int modCount = 0;

    /**
     * @param localNode - node, which used in recursion method.
     * @param element   - received element.
     * @return - Node with element value.
     */
    private Node<E> add(Node<E> localNode, E element) {
        if (localNode == null) {
            localNode = new Node<>(element);
            return localNode;
        }
        if (localNode.getElement().compareTo(element) == 1
                || localNode.getElement().compareTo(element) == 0) {
            localNode.setLeftChild(add(localNode.getLeftChild(), element));
        } else {
            localNode.setRightChild(add(localNode.getRightChild(), element));
        }
        return localNode;
    }

    /**
     * add to the element to the binarySearchTree.
     * @param element - element which will be added.
     */
    public void add(E element) {
        root = add(root, element);
        modCount++;
    }

    /**
     * Getter for root.
     * @return - root.
     */
    public Node<E> getRoot() {
        if (root != null) {
            return root;
        } else {
            throw new IllegalStateException("root is empty");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> queue = new LinkedList<>();
            int expectedCount = modCount;
            int iterAction = 0;

            /**
             * this method is using for add to the que all nodes.
             * @param eNode - root.
             */
            public void addToTheQueQue(Node<E> eNode) {
                if (eNode != null) {
                    this.queue.offer(eNode);
                    addToTheQueQue(eNode.getLeftChild());
                    addToTheQueQue(eNode.getRightChild());
                }
            }

            @Override
            public boolean hasNext() {
                return iterAction == 0 && root != null || !queue.isEmpty();
            }

            @Override
            public E next() {
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (iterAction == 0) {
                    addToTheQueQue(root);
                    iterAction = 1;
                }
                if (hasNext()) {
                    return queue.poll().getElement();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
