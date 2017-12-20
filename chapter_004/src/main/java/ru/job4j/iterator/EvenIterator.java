package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] array;

    /**
     * Constructor.
     * @param array - received array.
     */
    public EvenIterator(final int[] array) {
        this.array = array;
    }
    private int currentPosition = 0;
    private int iterIndex = 0;
    private Integer result = 0;

    /**
     * Override hasNext.
     * @return - boolean result of hasNext.
     */
    @Override
    public boolean hasNext() {
        boolean resultHasNext = false;
        for ( ; currentPosition <= array.length; ++currentPosition) {
            if (currentPosition == array.length) {
                break;
            }
            if (array[currentPosition] % 2 == 0) {
                resultHasNext = true;
                break;
            }
        }
        return resultHasNext;
    }

    /**
     * Override method next.
     * @return - next object.
     */
    @Override
    public Object next() {
        for ( ; iterIndex <= array.length; iterIndex++) {
            if (iterIndex == array.length) {
                throw new NoSuchElementException("No more even elements.");
            }
            if (array[iterIndex] % 2 == 0) {
                result = array[iterIndex];
                currentPosition = iterIndex;
                iterIndex = ++currentPosition;
                break;
            }
        }
        return result;
    }
}
