package ru.job4j.chess;

/**
 * ImpossibleMoveException.
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * constructor.
     * @param msg - message.
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
