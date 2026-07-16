package controller;

import static constant.AppConstants.EMPTY_INPUT_ERROR;
import static constant.AppConstants.INPUT_PROMPT;

import java.util.Map;
import service.WordCountService;
import view.InputView;

/**
 * Controls the main flow of the application.
 */
public class WordCountController {

    private final WordCountService countService;
    private final InputView inputView;

    /**
     * Creates the controller with service and view.
     */
    public WordCountController() {
        this.countService =
                new WordCountService();
        this.inputView = new InputView();
    }

    /**
     * Runs the app: input -> process -> display.
     */
    public void run() {
        String content = inputView
                .getNonEmptyString(
                        INPUT_PROMPT,
                        EMPTY_INPUT_ERROR);

        Map<String, Integer> wordResult =
                countService.countWords(content);
        Map<Character, Integer> charResult =
                countService.countCharacters(
                        content);

        displayResult(wordResult, charResult);
    }

    /**
     * Prints the word and character counts to
     * the console.
     *
     * @param wordResult map of word counts
     * @param charResult map of character counts
     */
    private void displayResult(
            Map<String, Integer> wordResult,
            Map<Character, Integer> charResult) {
        System.out.println(wordResult);
        System.out.println(charResult);
    }
}
