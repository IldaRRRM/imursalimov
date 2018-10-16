package ru.job4j.switcher;

import ru.job4j.switcher.mutal.Mutual;

import java.util.concurrent.Callable;

public class Switcher implements Callable<String> {

    private final Integer step;
    private final Mutual mutalObject;
    private final Integer number;

    public Switcher(Mutual mutalObject, Integer step, Integer number) {
        this.mutalObject = mutalObject;
        this.step = step;
        this.number = number;
    }


    @Override
    public String call() throws Exception {
        for (int i = 0; i < step; i++) {
            mutalObject.fromIntToString(number);
        }
        System.out.printf("%s%n", mutalObject.getResult());
        return mutalObject.getResult().toString();
    }
}
