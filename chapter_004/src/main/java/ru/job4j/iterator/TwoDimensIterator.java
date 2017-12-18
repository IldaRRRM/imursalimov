package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensIterator implements Iterator {

    private final int[][] arr;

    private int rowInd = 0;

    private int columnPos = 0;

    /**
     * Constructor.
     * @param arr - received arr.
     */
    public TwoDimensIterator(final int[][] arr) {
        this.arr = arr;
    }
    /**
     * Override HasNext.
     * @return - override hasNext.
     */
    @Override
    public boolean hasNext() {
        return arr.length > rowInd;

    }
    /**
     * Override nextMethod.
     * @return - override next() method.
     */
    @Override
    public Object next() {
        Integer result = 0;
        if (rowInd > arr.length - 1) {
            throw new NoSuchElementException("End of array");
        } else {
            result = arr[rowInd][columnPos++];
        }
        if (columnPos == arr[rowInd].length) {
            columnPos = 0;
            rowInd++;
        }
        return result;
    }
}
