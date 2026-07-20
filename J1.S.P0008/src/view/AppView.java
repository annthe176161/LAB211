package view;

import static constant.AppConstants.EMPTY_INPUT_ERROR;
import static constant.AppConstants.INPUT_PROMPT;

import java.util.Map;
import java.util.Scanner;

/**
 * Handles all user input and output.
 */
public class AppView {

    private final Scanner scanner;

    /**
     * Creates an AppView that reads from
     * System.in.
     */
    public AppView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Asks the user to enter a non-empty string.
     * Keeps asking until a valid input is given.
     *
     * @return a valid non-empty string
     */
    public String getNonEmptyString() {
        String input;
        while (true) {
            System.out.println(INPUT_PROMPT);
            input = scanner.nextLine();
            if (input == null
                    || input.trim().isEmpty()) {
                System.out.println(
                        EMPTY_INPUT_ERROR);
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Displays the word and character counts.
     *
     * @param wordResult map of word counts
     * @param charResult map of character counts
     */
    public void displayResult(
            Map<String, Integer> wordResult,
            Map<Character, Integer> charResult) {
        System.out.println(wordResult);
        System.out.println(charResult);
    }
}
