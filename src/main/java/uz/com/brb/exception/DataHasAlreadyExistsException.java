package uz.com.brb.exception;

public class DataHasAlreadyExistsException extends RuntimeException {
    public DataHasAlreadyExistsException(String message) {
        super(message);
    }
}
