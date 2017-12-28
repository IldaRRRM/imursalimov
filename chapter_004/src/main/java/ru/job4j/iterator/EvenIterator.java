package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    /**
     * received array.
     */
    private final int[] array;
    /**
     * current position of cursor.
     */
    private int currentPosition = 0;
    /**
     * Constructor.
     * @param array - received array.
     */
    public EvenIterator(final int[] array) {
        this.array = array;
    }
    /**
     * Override hasNext.
     * @return - boolean result of hasNext.
     */
    @Override
    public boolean hasNext() {
        int iterIndex = currentPosition;
        boolean resultHasNext = false;
        if (currentPosition > 0) {
            currentPosition++;
        }
        for ( ; currentPosition <= array.length; ++currentPosition) {
            if (currentPosition == array.length) {
                currentPosition = iterIndex;
                break;
            }
            if (array[currentPosition] % 2 == 0) {
                resultHasNext = true;
                currentPosition = iterIndex;
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
        int result = 0;
        if (currentPosition > 0) {
            currentPosition++;
        }
        for ( ; currentPosition <= array.length; currentPosition++) {
            if (currentPosition == array.length) {
                throw new NoSuchElementException("No more even elements.");
            }
            if (array[currentPosition] % 2 == 0) {
                result = array[currentPosition];
                break;
            }
        }
        return result;
    }
}
