package exception;

/**
 * Thrown when dividing by zero.
 */
public class DivisionByZeroException
        extends ArithmeticException {

    /**
     * Constructs with default message.
     */
    public DivisionByZeroException() {
        super("Cannot divide by zero!");
    }
}
