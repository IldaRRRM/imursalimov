package ru.job4j.exchangeglass.applicationinnerclasses;

public class Action {

    private boolean bid;

    private boolean ask;

    public Action(String bidOrAsk) {
        if (bidOrAsk.toLowerCase().equals("bid")) {
            bid = true;
        } else if (bidOrAsk.toLowerCase().equals("ask")) {
            ask = true;
        }
    }

    public boolean isBid() {
        return bid;
    }

    public boolean isAsk() {
        return ask;
    }
}

