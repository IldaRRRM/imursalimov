package ru.job4j.nonblockingalgoritm;

import org.junit.Test;
import ru.job4j.nonblockingalgoritm.exception.OptimisticException;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashBaseTest {

    private final HashBase hashBase = new HashBase();


    @Test
    public void add() {
        Base base = new Base(1, 1);
        hashBase.add(base);
        hashBase.add(base);
        hashBase.add(new Base(2, 1));
        hashBase.getConcurrentHashMap().get(1);
        assertThat(hashBase.getConcurrentHashMap().get(1), is(base));
        assertThat(hashBase.getConcurrentHashMap().size(), is(2));
    }

    @Test
    public void whenTwoThreadsAreUpdatesInOneTime() throws InterruptedException {
        Base base = new Base(7, 0);
        hashBase.add(base);
        try {
            hashBase.update(base);
            new Thread(() -> hashBase.update(base)).start();
//            new Thread(() -> hashBase.update(base)).start();
        } catch (OptimisticException msg) {
            System.out.println("I know");
        }
        assertThat(hashBase.getConcurrentHashMap().get(7).getVersion(), is(1));

    }

    @Test
    public void delete() {
        Base base = new Base(2, 1);
        hashBase.add(base);
        assertThat(hashBase.getConcurrentHashMap().get(2), is(base));
        hashBase.delete(base);
        Optional<Base> optionalBase = Optional.ofNullable(hashBase.getConcurrentHashMap().get(2));
        assertThat(optionalBase.isPresent(), is(false));
        assertThat(hashBase.getConcurrentHashMap().size(), is(0));

    }
}