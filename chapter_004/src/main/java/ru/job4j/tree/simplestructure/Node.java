package ru.job4j.tree.simplestructure;

import java.util.ArrayList;
import java.util.List;

public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();

    private final E value;

    public Node(E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Getter.
     * @return - value.
     */
    public E getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?> node = (Node<?>) o;

        return value != null ? value.equals(node.value) : node.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
