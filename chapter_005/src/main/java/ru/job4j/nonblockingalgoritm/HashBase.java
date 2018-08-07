package ru.job4j.nonblockingalgoritm;

import ru.job4j.nonblockingalgoritm.exception.OptimisticException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class HashBase {

    private final ConcurrentHashMap<Integer, Base> concurrentHashMap = new ConcurrentHashMap<>();

    public void add(Base model) {
        concurrentHashMap.putIfAbsent(model.getId(), model);
    }

    public void update(Base model) {
        concurrentHashMap.computeIfPresent(model.getId(), new BiFunction<Integer, Base, Base>() {
            @Override
            public Base apply(Integer integer, Base base) {
                if (base.getVersion() == model.getVersion()) {
                    return new Base(integer, base.getVersion() + 1);
                }
                String msgForException = String.format("Version conflict : Expected %s but was %s.%n", model.getVersion(), base.getVersion());
                throw new OptimisticException(msgForException);
            }
        });
    }

    public void delete(Base model) {
        concurrentHashMap.computeIfPresent(model.getId(), (integer, base) -> base = null);
    }

    public ConcurrentHashMap<Integer, Base> getConcurrentHashMap() {
        return concurrentHashMap;
    }

}
