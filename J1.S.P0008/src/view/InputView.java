package view;

import java.util.Scanner;

/**
 * Handles user input from the keyboard.
 */
public class InputView {

    private final Scanner scanner;

    /**
     * Creates an InputView that reads from
     * System.in.
     */
    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Asks the user to enter a non-empty string.
     * Keeps asking until a valid input is given.
     *
     * @param prompt the message shown to the user
     * @param errorMsg the error message for invalid
     *                 input
     * @return a valid non-empty string
     */
    public String getNonEmptyString(
            String prompt, String errorMsg) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input == null
                    || input.trim().isEmpty()) {
                System.out.println(errorMsg);
            } else {
                break;
            }
        }
        return input;
    }
}
