package ru.job4j.bomberman.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Проверяемое исключение
 */
public class IllegalMoveException extends Exception {
    private final static Logger EXCEPTIONLOG = LoggerFactory.getLogger(IllegalMoveException.class);

    public IllegalMoveException(String message) {
        EXCEPTIONLOG.error(message);
    }
}
