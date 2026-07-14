package exception;

import entity.Operator;

/**
 * Thrown when an invalid operator is used.
 */
public class InvalidOperatorException
        extends ArithmeticException {

    /**
     * Constructs with the invalid operator.
     *
     * @param operator the invalid operator
     */
    public InvalidOperatorException(Operator operator) {
        super("Invalid operator: " + operator);
    }
}
