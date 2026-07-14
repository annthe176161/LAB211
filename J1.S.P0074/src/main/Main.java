package main;

import constant.MatrixOperation;
import validation.InputValidator;
import view.MatrixUI;

/**
 * Entry point for the matrix calculator program.
 */
public class Main {

    /**
     * Main method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        final MatrixUI ui = new MatrixUI();
        boolean isRunning = true;

        while (isRunning) {
            ui.displayMenu();

            final int choice =
                    InputValidator.checkInputIntLimit(
                            1, 4,
                            "Your choice: ",
                            "Please input a valid choice.",
                            "Please input a number "
                            + "inside the range [1, 4]"
                    );

            if (choice == MatrixOperation.QUIT) {
                System.out.println(
                        "Exiting program...");
                isRunning = false;
            } else {
                ui.performMatrixOperation(choice);
                System.out.println();
            }
        }
    }
}
