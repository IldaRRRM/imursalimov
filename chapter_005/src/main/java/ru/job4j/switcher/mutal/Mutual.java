package ru.job4j.switcher.mutal;


import java.util.concurrent.locks.ReentrantLock;

public interface Mutual<E> {

    public void fromIntToString(Integer number);

    public E getResult();

    public ReentrantLock getLockObject();

}
