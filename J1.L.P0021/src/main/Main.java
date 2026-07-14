package main;

import constant.AppConfigs;
import controller.StudentManager;
import utility.Validation;

/**
 * Entry point of the Student Management application.
 */
public class Main {

    /**
     * Main method that runs the program loop.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        boolean running = true;

        while (running) {
            System.out.println(
                    "\n========== WELCOME TO STUDENT MANAGEMENT ==========");
            System.out.println(AppConfigs.CREATE + ". Create");
            System.out.println(AppConfigs.FIND_AND_SORT + ". Find and Sort");
            System.out.println(AppConfigs.UPDATE_OR_DELETE + ". Update/Delete");
            System.out.println(AppConfigs.REPORT + ". Report");
            System.out.println(AppConfigs.EXIT + ". Exit");
            System.out.println(
                    "==================================================");

            int choice = Validation.readInteger(
                    "Please choose (1-5): ",
                    AppConfigs.CREATE, AppConfigs.EXIT,
                    "Error: Input must be a number!",
                    "Error: Choice must be from 1 to 5!");

            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.generateReport();
                    break;
                case 5:
                    System.out.println(
                            "Thank you for using the system. Goodbye!");
                    running = false;
                    break;
            }
        }
    }
}
