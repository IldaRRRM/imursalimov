package ru.job4j.switcher.switcherfuturetask;


import java.util.concurrent.FutureTask;

public class SwitcherFuterTask extends FutureTask<SwitcherFuterTask>
        implements Comparable<SwitcherFuterTask> {

    private final Switcher switcher;


    public SwitcherFuterTask(Switcher switcher) {
        super(switcher, null);
        this.switcher = switcher;
    }

    @Override
    public int compareTo(SwitcherFuterTask another) {
        return switcher.getPriority().compareTo(another.switcher.getPriority());
    }

}
