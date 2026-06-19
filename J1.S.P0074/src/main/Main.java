/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import biz.MatrixOperation;
import validation.InputValidator;
import view.MatrixUI;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        MatrixUI ui = new MatrixUI();
        boolean isRunning = true;

        while (isRunning == true) {
            ui.displayMenu();

            int choice = InputValidator.checkInputIntLimit(
                    1, 4,
                    "Your choice: ",
                    "Please input a valid choice.",
                    "Please input a number inside the range [1, 4]"
            );

            MatrixOperation operation = MatrixOperation.fromChoice(choice);

            if (operation == MatrixOperation.QUIT) {
                System.out.println("Exiting program...");
                isRunning = false;
            } else {
                ui.performMatrixOperation(operation);
                System.out.println();
            }
        }
    }
}
