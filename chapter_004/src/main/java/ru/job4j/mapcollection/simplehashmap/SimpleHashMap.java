package ru.job4j.mapcollection.simplehashmap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * SimpleHashMapCollection.
 */

public class SimpleHashMap<K, V> {

    private int arrSize;

    private int keyCountValue = 0;

    private int freeCell;

    private int modCount = 0;

    private Object[] array;

    private Object[] keyStore;

    /**
     * public constructor.
     */
    public SimpleHashMap() {

        this.arrSize = 16;
        this.array = new Object[arrSize];
        this.keyStore = new Object[arrSize];
        this.freeCell = this.arrSize;
    }

    /**
     * constructor with size.
     * @param size - new size.
     */
    public SimpleHashMap(int size) {
        this.arrSize = size;
        this.array = new Object[arrSize];
        this.keyStore = new Object[arrSize];
        this.freeCell = this.arrSize;
    }

    /**
     * KeyIterator.
     * @return - KeyIterator.
     */

    public Iterator keyIterator() {
        return new Iterator() {
            int keyIterIndex = 0;
            int expectedCount = modCount;
            @Override
            public boolean hasNext() {
                return keyIterIndex < keyCountValue;
            }

            @Override
            public K next() {
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (K) keyStore[keyIterIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    /**
     * ValueIterator.
     * @return - valueIterator.
     */
    public Iterator valueIterator() {
        return new Iterator() {
            int expectedCount = modCount;
            int valueIterIndex = 0;
            @Override
            public boolean hasNext() {
                return valueIterIndex < keyCountValue;
            }

            @Override
            public V next() {
                if (modCount != expectedCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    int hashValue = hashFunction((K) keyStore[valueIterIndex++]);
                    return (V) array[hashValue];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    /**
     * Getter for arrSize.
     * @return - arrSize.
     */
    public int getArrSize() {
        return arrSize;
    }
    /**
     * @param key - received key.
     * @return - hashFunction for simpleHashMap.
     */
    private int hashFunction(K key) {
        int promHash = key.hashCode();
        return Math.abs(promHash % this.arrSize);
    }

    /**
     * @param index - index.
     * @param value - received value.
     * @return - boolean result.
     */
    private boolean addToTheArray(int index, V value) {
        if (this.array[index] == null) {
            this.array[index] = value;
            freeCell--;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param key - received key.
     * @param value - received value.
     * @return - boolean result.
     */
    public boolean insert(K key, V value) {
        checkFreeCells();
        if (addToTheArray(hashFunction(key), value)) {
            keyStore[keyCountValue++] = key;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param key - received key.
     * @return - value.
     */
    V get(K key) {
        return (V) array[hashFunction(key)];
    }

    /**
     * @param key - key.
     * @return - boolean result.
     */
    boolean delete(K key) {
        int hashValue = hashFunction(key);
        if (array[hashValue] != null) {
            array[hashValue] = null;
            freeCell--;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * check free Cells.
     */
    private void checkFreeCells() {
        if (freeCell == 0) {
            SimpleHashMap<K, V> simpleHashMap = new SimpleHashMap<>(arrSize * 2);
            for (Object keys : keyStore) {
                if (keys != null) {
                    int hashFunk = hashFunction((K) keys);
                    simpleHashMap.insert((K) keys, (V) array[hashFunk]);
                }
            }
            this.arrSize = simpleHashMap.arrSize;
            this.array = simpleHashMap.array;
            this.freeCell = simpleHashMap.freeCell;
            this.keyStore = simpleHashMap.keyStore;
        }
    }
}
