package ru.job4j.exchangeglass;

import ru.job4j.exchangeglass.applicationinnerclasses.Action;
import ru.job4j.exchangeglass.applicationinnerclasses.TypeOfApplication;


import java.util.Random;


/**
 * id - уникальный ключ заявки.
 * <p>
 * book - идентификатор ценной бумаги.
 * <p>
 * type - add/delete - выставить заявку на торги или снять
 * <p>
 * action - bid/ask - заявка имеет два действия. Заявка на покупка ценной бумаги или на продажу.
 * <p>
 * price - цена, по которой мы ходим сделать действия покупки или продажи.
 * <p>
 * volume - количество акций, которые мы ходим продать или купить.
 */
public class Application {

    private final int id;

    private int book;

    private TypeOfApplication type;

    private Action action;

    private int price;

    private int volume;

    /**
     * @param book   - unic number of security paper.
     * @param type   - type of application add or delete.
     * @param action - application has bid or ask action.
     * @param price  - price of application.
     * @param volume - volume
     */
    public Application(int book, TypeOfApplication type, Action action, int price, int volume) {
        this.id = generatedId();
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Method generates a unique id for application.
     *
     * @return - unique id.
     */
    public int generatedId() {
        Random random = new Random();
        return Math.abs(random.nextInt(1000) * (int) System.currentTimeMillis());
    }


    /**
     * Getter for type of application.
     *
     * @return - type of application.
     */
    public TypeOfApplication getType() {
        return type;
    }

    /**
     * Action getter.
     *
     * @return - type of action bid or ask.
     */
    public Action getAction() {
        return action;
    }

    /**
     * Getter for id.
     *
     * @return - number of id.
     */
    public int getId() {
        return id;
    }

    public int getBook() {
        return book;
    }

    /**
     * Getter for price.
     *
     * @return - return price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter fo volume.
     *
     * @return - value of volume.
     */
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }


        Application that = (Application) o;

        if (book != that.book) {

            return false;
        }
        return price == that.price && volume == that.volume;
    }

    @Override
    public int hashCode() {
        int result = book;
        result = 31 * result + price;
        result = 31 * result + volume;
        return result;
    }
}
