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
     * @return a valid non-empty string
     */
    public String getNonEmptyString(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input == null
                    || input.trim().isEmpty()) {
                System.out.println(
                        "Input cannot be empty!"
                        + " Please enter again.");
            } else {
                break;
            }
        } while (true);
        return input;
    }
}
