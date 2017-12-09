package ru.job4j.chess;

public class OccupiedWayException extends RuntimeException {
    /**
     * Constructor.
     * @param msg message.
     */
    public OccupiedWayException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
