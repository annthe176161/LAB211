package main;

import controller.WordCountController;

/**
 * Main class that starts the word and
 * character count program.
 */
public class Main {

    /**
     * Entry point. Creates the controller and
     * runs the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        WordCountController controller =
                new WordCountController();
        controller.run();
    }
}
