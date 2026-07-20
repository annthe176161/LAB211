package controller;

import java.util.Map;
import service.WordCountService;
import view.AppView;

/**
 * Controls the main flow of the application.
 */
public class WordCountController {

    private final WordCountService countService;
    private final AppView appView;

    /**
     * Creates the controller with service and view.
     */
    public WordCountController() {
        this.countService =
                new WordCountService();
        this.appView = new AppView();
    }

    /**
     * Runs the app: input -> process -> display.
     */
    public void run() {
        String content =
                appView.getNonEmptyString();

        Map<String, Integer> wordResult =
                countService.countWords(content);
        Map<Character, Integer> charResult =
                countService.countCharacters(
                        content);

        appView.displayResult(
                wordResult, charResult);
    }
}
