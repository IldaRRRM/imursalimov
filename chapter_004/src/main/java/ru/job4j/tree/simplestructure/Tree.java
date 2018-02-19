package ru.job4j.tree.simplestructure;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private int modCount = 0;

    private Node<E> root;

    /**
     * @param parent - parent of child node.
     * @param child  - child node of parent.
     * @return - boolean result of add element to tree.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (root == null) {
            root = new Node<>(parent);
            root.leaves().add(new Node<>(child));
            modCount++;
            result = true;
        } else {
            if (findBy(parent).isPresent()) {
                if (findBy(child).isPresent()) {
                    return false;
                }
                Node<E> node = findBy(parent).get();
                node.leaves().add(new Node<>(child));
                modCount++;
                result = true;
            }
        }
        return result;
    }

    /**
     * @param value - value, that we'll look for.
     * @return - Node in optional construction.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        int binarySummCheck = 0;
        Queue<Node<E>> queNode = new LinkedList<>();
        if (root == null) {
            return false;
        } else {
            queNode.offer(root);
            while (!queNode.isEmpty()) {
                Node<E> promNode = queNode.poll();
                for (Node<E> childreen : promNode.leaves()) {
                    queNode.offer(childreen);
                    binarySummCheck++;
                }
                if (binarySummCheck > 2) {
                    return false;
                } else {
                    binarySummCheck = 0;
                }
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int exptectedModCount = modCount;

            Queue<Node<E>> queue = new LinkedList<>();

            byte iter = 0;

            @Override
            public boolean hasNext() {
                if (iter == 0) {
                    return root != null;
                }
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                if (exptectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (iter == 0) {
                    queue.offer(root);
                    iter++;
                }
                if (!queue.isEmpty()) {
                    Node<E> node = queue.poll();
                    for (Node<E> children : node.leaves()) {
                        queue.offer(children);
                    }
                    return node.getValue();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
