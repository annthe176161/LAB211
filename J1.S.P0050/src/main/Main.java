package main;

import controller.EquationController;

/**
 * Application entry point.
 */
public class Main {

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        EquationController controller = new EquationController();
        controller.run();
    }
}
