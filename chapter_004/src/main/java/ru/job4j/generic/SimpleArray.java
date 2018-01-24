package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;

    private int index = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int iterableValue = 0;

            @Override
            public boolean hasNext() {
                System.out.println(iterableValue);
                System.out.println(index);
                return iterableValue + 1 <= index;
            }


            @Override
            public T next() {
                if (hasNext()) {
                    return (T) objects[iterableValue++];
                } else {
                    throw new NoSuchElementException("No such element");
                }
            }
        };
    }

    /**
     * Constructor.
     * @param size - size of arr.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * @param position - position, what we need.
     * @return - requared object.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }


    /**
     * @param model - add model.
     */
    public void add(T model) {
        objects[index++] = model;
    }

    /**
     * @param index - index.
     * @param model - received param.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * delete.
     * @param index - index.
     */
    public void delete(int index) {
        for (int i = index; i < objects.length - 1; i++) {
            Object tmp = objects[i];
            objects[i] = objects[i + 1];
            objects[i + 1] = tmp;
        }
        this.objects[objects.length - 1] = null;
        this.index--;
    }

    /**
     * getter for objects.
     * @return - array of objects.
     */
    public Object[] getObjects() {
        return objects;
    }
}
