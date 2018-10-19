package ru.job4j.switcher.switcherfuturetask;

import ru.job4j.switcher.mutal.Mutual;
import ru.job4j.switcher.priority.Priority;


public class Switcher implements Runnable {

    private final Integer step;
    private final Mutual mutalObject;
    private final Integer number;
    private final Priority priority;


    public Switcher(Mutual mutalObject, Integer step, Integer number, Priority priority) {
        this.mutalObject = mutalObject;
        this.step = step;
        this.number = number;
        this.priority = priority;
    }


    @Override
    public void run() {
        mutalObject.getLockObject().lock();
        for (int i = 0; i < step; i++) {
            mutalObject.fromIntToString(number);
        }
        System.out.printf("%s%n", mutalObject.getResult());
        mutalObject.getLockObject().unlock();
    }

    Priority getPriority() {
        return priority;
    }

}
