package constant;

/**
 * Stores all application constants.
 */
public final class AppConstants {

    private AppConstants() {
    }

    /** Characters used to split words. */
    public static final String DELIMITERS =
            " \t\n\r\f.,;:!?";

    /** Prompt message for user input. */
    public static final String INPUT_PROMPT =
            "Enter your content:";

    /** Error message for empty input. */
    public static final String EMPTY_INPUT_ERROR =
            "Input cannot be empty!"
            + " Please enter again.";
}
