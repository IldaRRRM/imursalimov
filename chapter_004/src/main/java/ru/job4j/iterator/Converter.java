package ru.job4j.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    /**
     * @param it - received iterator.
     * @return - general iterator for all iterators.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            Iterator<Integer> currentIterator;

            @Override
            public boolean hasNext() {
                return it.hasNext() || currentIterator.hasNext() && currentIterator != null;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    if (currentIterator == null || !currentIterator.hasNext()) {
                        currentIterator = it.next();
                    }
                    return currentIterator.next();
                } else {
                    throw new NoSuchElementException("no Such element");
                }
            }
        };
    }
}


