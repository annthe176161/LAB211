package constant;

/**
 * Stores all user-facing messages and error strings.
 */
public final class MessageConstant {

    public static final String MSG_INVALID_NUMBER =
            "Values must be a valid number.";
    public static final String MSG_GREATER_THAN_ZERO =
            "Value must be greater than 0.";
    public static final String MSG_MATRIX_DIGIT =
            "Value of matrix is digit";

    public static final String ERR_SIZE_ADD_SUB =
            "Error: Matrices must have the same dimensions"
            + " for addition/subtraction!";
    public static final String ERR_SIZE_MUL =
            "Error: Rows of Matrix 2 must equal Columns"
            + " of Matrix 1!";

    private MessageConstant() {
    }
}
