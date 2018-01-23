package ru.job4j.list;

public interface Container<E> extends Iterable<E> {

    void add(E model);

    E get(int index);
}
