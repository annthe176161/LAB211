package constant;

/**
 * Stores operation type constants and symbol mapping.
 */
public final class MatrixOperation {

    public static final int ADDITION = 1;
    public static final int SUBTRACTION = 2;
    public static final int MULTIPLICATION = 3;
    public static final int QUIT = 4;

    private MatrixOperation() {
    }

    /**
     * Get symbol for display based on operation choice.
     *
     * @param choice operation number
     * @return operator symbol string
     */
    public static String getSymbol(int choice) {
        switch (choice) {
            case ADDITION:
                return "+";
            case SUBTRACTION:
                return "-";
            case MULTIPLICATION:
                return "*";
            default:
                return "";
        }
    }
}
