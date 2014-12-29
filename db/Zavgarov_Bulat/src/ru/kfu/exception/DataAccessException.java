package ru.kfu.exception;

/**
 * Created by Bulat on 25.12.14.
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException() {
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
