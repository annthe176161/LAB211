/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import constant.MessageConstant;
import entity.Person;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class PersonView {

    /**
     * Prompts the user to input a positive double value. This method can be
     * reused for any positive number inputs.
     *
     * @param scanner the Scanner object for user input
     * @param prompt the message displayed to guide the user
     * @return a valid positive double value entered by the user
     */
    public double inputPositiveDouble(Scanner scanner, String prompt) {
        boolean isValid = false;
        double value = 0;

        while (isValid == false) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(MessageConstant.ERROR_DIGIT);
            } else {
                try {
                    value = Double.parseDouble(input);
                    if (value <= 0) {
                        System.out.println(MessageConstant.ERROR_GREATER_THAN_ZERO);
                    } else {
                        isValid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MessageConstant.ERROR_DIGIT);
                }
            }
        }
        return value;
    }

    /**
     * Displays information of a Person object to the screen.
     *
     * @param person the Person object to be displayed
     */
    public void displayPersonInfo(Person person) {
        if (person == null) {
            return;
        }
        System.out.println("Information of Person you have entered:");
        System.out.println("Name:" + person.getName());
        System.out.println("Address:" + person.getAddress());
        System.out.println("Salary:" + person.getSalary());
    }
}
