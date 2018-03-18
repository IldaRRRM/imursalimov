package ru.job4j.exchangeglass;

import java.util.*;

public class Glasses {

    private List<Application> bidGlass;

    private List<Application> askGlass;

    /**
     * defalult constructor.
     */
    public Glasses() {
        this.bidGlass = new ArrayList<>();
        this.askGlass = new ArrayList<>();
    }

    /**
     *
     * @param askGlass - glass with ask application.
     * @param bidGlass - glass which includes bid application.
     */
    public Glasses(List<Application> askGlass, List<Application> bidGlass) {
        this.askGlass = askGlass;
        this.bidGlass = bidGlass;
    }
    /**
     * PurchaseGlass.
     * @return - bidGlass.
     */
    public List<Application> getBidGlass() {
        return bidGlass;
    }

    /**
     * SaleGlass.
     * @return - saleGlass.
     */
    public List<Application> getAskGlass() {
        return askGlass;
    }

}
