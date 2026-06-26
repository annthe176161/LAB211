/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.StudentManager;
import enums.MenuOption;
import util.Validation;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        int minMenuValue = MenuOption.CREATE.getValue();
        int maxMenuValue = MenuOption.EXIT.getValue();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n================ WELCOME TO STUDENT MANAGEMENT ================");
            System.out.println(MenuOption.CREATE.getValue() + ". Create");
            System.out.println(MenuOption.FIND_AND_SORT.getValue() + ". Find and Sort");
            System.out.println(MenuOption.UPDATE_OR_DELETE.getValue() + ". Update/Delete");
            System.out.println(MenuOption.REPORT.getValue() + ". Report");
            System.out.println(MenuOption.EXIT.getValue() + ". Exit");
            System.out.println("===============================================================");

            int rawChoice = Validation.inputInt(
                    "Please choose (" + minMenuValue + "-" + maxMenuValue + "): ",
                    minMenuValue,
                    maxMenuValue,
                    "Error: Input must be a valid number!",
                    "Error: Choice must be between " + minMenuValue + " and " + maxMenuValue + "!"
            );

            MenuOption option = MenuOption.fromInt(rawChoice);

            if (option == null) {
                System.err.println("Error: Internal error matching option selection symbol.");
                continue;
            }

            switch (option) {
                case CREATE:
                    manager.createStudent();
                    break;
                case FIND_AND_SORT:
                    manager.findAndSort();
                    break;
                case UPDATE_OR_DELETE:
                    manager.updateOrDelete();
                    break;
                case REPORT:
                    manager.generateReport();
                    break;
                case EXIT:
                    System.out.println("Thank you for using the system. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
