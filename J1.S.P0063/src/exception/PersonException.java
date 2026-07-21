package exception;

/**
 * Thrown when Person data is invalid
 * or operation fails.
 */
public class PersonException extends Exception {

    public PersonException(String message) {
        super(message);
    }
}
