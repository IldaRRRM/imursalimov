package ru.job4j.mapcollection.simplehashmap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleHashMapCollection.
 */

public class SimpleHashMap<K, V> {

    private int freeCell;

    private int modCount = 0;

    private Store<K, V>[] array;

    /**
     * public constructor.
     */
    public SimpleHashMap() {

        this.array = new Store[16];
        this.freeCell = array.length;

    }

    /**
     * constructor with size.
     *
     * @param size - new size.
     */
    public SimpleHashMap(int size) {
        this.array = new Store[size];
        this.freeCell = array.length;
    }

    /**
     * Getter for arrSize.
     *
     * @return - arrSize.
     */
    public int getArrSize() {
        return this.array.length;
    }

    /**
     * @param key - received key.
     * @return - hashFunction for simpleHashMap.
     */
    private int hashFunction(K key) {
        int promHash = key.hashCode();
        return Math.abs(promHash % this.array.length);
    }

    /**
     * @param index - index.
     * @param value - received value.
     * @return - boolean result.
     */
    private boolean addToTheArray(K key, V value, int index) {
        if (this.array[index] == null) {
            this.array[index] = new Store<>(key, value);
            freeCell--;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param key   - received key.
     * @param value - received value.
     * @return - boolean result.
     */
    public boolean insert(K key, V value) {
        checkFreeCells();
        return addToTheArray(key, value, hashFunction(key));
    }

    /**
     * @param key - received key.
     * @return - value.
     */
    V get(K key) {
        if (array[hashFunction(key)] != null) {
            return array[hashFunction(key)].getValue();
        } else {
            throw new IllegalStateException("The key is null");
        }
    }

    /**
     * @param key - key.
     * @return - boolean result.
     */
    boolean delete(K key) {
        int hashValue = hashFunction(key);
        if (array[hashValue] != null) {
            array[hashValue] = null;
            freeCell++;
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
            SimpleHashMap<K, V> simpleHashMap = new SimpleHashMap<>(array.length * 2);
            for (Store keys : array) {
                if (keys != null) {
                    int hashFunk = hashFunction((K) keys.getKey());
                    simpleHashMap.insert((K) keys.getKey(), array[hashFunk].getValue());
                }
            }
            this.array = simpleHashMap.array;
            this.freeCell = simpleHashMap.freeCell;
        }
    }

    /**
     * KeyIterator.
     * @return - KeyIterator.
     */

    public Iterator keyIterator() {
        return new Iterator() {
            int tmpValue = 0;
            int keyIterIndex = 0;
            int expectedCount = modCount;
            K result = null;

            @Override
            public boolean hasNext() {
                return keyIterIndex < array.length - freeCell;
            }

            @Override
            public K next() {
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    for (int i = tmpValue; i < array.length; i++) {
                        if (array[i] != null) {
                            tmpValue = i;
                            tmpValue++;
                            keyIterIndex++;
                            result = array[i].getKey();
                            break;
                        }
                    }
                    return result;
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
            int tmpValue = 0;
            int valueIterIndex = 0;
            V result = null;

            @Override
            public boolean hasNext() {
                return valueIterIndex < array.length - freeCell;
            }

            @Override
            public V next() {
                if (modCount != expectedCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    for (int i = tmpValue; i < array.length; i++) {
                        if (array[i] != null) {
                            tmpValue = i;
                            tmpValue++;
                            valueIterIndex++;
                            result = array[i].getValue();
                            break;
                        }
                    }
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}