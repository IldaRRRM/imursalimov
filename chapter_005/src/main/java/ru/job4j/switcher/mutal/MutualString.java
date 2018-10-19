package ru.job4j.switcher.mutal;

import java.util.concurrent.locks.ReentrantLock;

public class MutualString implements Mutual<String> {

    private final ReentrantLock lock = new ReentrantLock();
    private volatile String resultStringOfSwithcer;


    public MutualString(String resultStringOfSwithcer) {
        this.resultStringOfSwithcer = resultStringOfSwithcer;
    }

    @Override
    public void fromIntToString(Integer number) {
        try {
            lock.tryLock();
            StringBuilder resultOfMethod = new StringBuilder(resultStringOfSwithcer);
            String valueOfNumber = String.valueOf(number);
            resultOfMethod.append(valueOfNumber);
            resultStringOfSwithcer = resultOfMethod.toString();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getResult() {
        return resultStringOfSwithcer;
    }

    @Override
    public ReentrantLock getLockObject() {
        return lock;
    }
}

