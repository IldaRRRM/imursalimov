package ru.job4j.tree.binarysearchtree;

public class Node<E extends Comparable<E>> {

    private E element;

    private Node<E> leftChild;

    private Node<E> rightChild;

    /**
     * Constructor.
     *
     * @param element - received element.
     */
    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
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

        return element != null ? element.equals(node.element) : node.element == null;
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }
}
