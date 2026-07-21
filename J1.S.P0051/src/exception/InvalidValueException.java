package exception;

/**
 * Thrown when weight or height is not positive.
 */
public class InvalidValueException
        extends ArithmeticException {

    /**
     * Constructs with a detail message.
     *
     * @param message detail message
     */
    public InvalidValueException(String message) {
        super(message);
    }
}
