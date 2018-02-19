package ru.job4j.mapcollection.simplehashmap;

public class Store<K, V> {

    private K key;

    private V value;

    /**
     *
     * @param key - received key.
     * @param value - received value.
     */
    public Store(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * key getter.
     * @return - key.
     */
    public K getKey() {
        return key;
    }

    /**
     * value getter.
     * @return - value.
     */
    public V getValue() {
        return value;
    }
}
