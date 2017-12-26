package ru.job4j.iterator;

import java.util.*;
/**
 *Class SimpleNumberIterator overrides methods has and next.
 */
public class SimpleNumberIterator implements Iterator {
    /**
     * received array.
     */
    private final int[] numbers;
    /**
     * current position.
     */
    private int curPos = 0;
    /**
     * Constructor.
     * @param numbers - finalize numbers.
     */
    public SimpleNumberIterator(final int[] numbers) {
        this.numbers = numbers;
    }
    /**
     * @param n - received number.
     * @return - boolean result.
     */
    public boolean isPrime(int n) {
        boolean result = true;
        if (n <= 1) {
            result = false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return (n % 2 != 0 && result && n > 2) || n == 2;
    }
    /**
     * @return - boolean result(is there prime element?).
     */
    @Override
    public boolean hasNext() {
        int prom = curPos;
        boolean result = false;
        boolean rpr = true;
        prom++;
        while (rpr) {
            if (prom >= numbers.length) {
                break;
            }
            if (isPrime(numbers[prom])) {
                result = true;
                break;
            } else {
                prom++;
            }
        }
        return result;
    }
    /**
     * Override method next.
     * @return - next prime object.
     */
    @Override
    public Object next() {
        boolean step = false;
        int prom = 0;
        Integer result = 0;
        if (curPos > 0) {
            curPos++;
        }
        while (!step) {
            if (curPos >= numbers.length) {
                curPos = prom;
                throw new NoSuchElementException("End of Array.");
            }
            if (isPrime(numbers[curPos]) && curPos < numbers.length) {
                prom = curPos;
                result = numbers[curPos];
                step = true;
            } else {
                curPos++;
            }
        }
        return result;
    }
}
