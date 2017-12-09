package ru.job4j.chess;

public class FigureNotFoundException extends RuntimeException {
    /**
     * Constructor.
     * @param msg message.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
