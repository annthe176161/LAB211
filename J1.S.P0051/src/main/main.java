/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import common.Validation;
import controller.Manager;
import entity.BMIStatus;
import entity.Operator;

/**
 *
 * @author admin
 */
public class main {

    public static void main(String[] args) {
        Manager manager = new Manager();

        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = Validation.checkInputIntLimit(
                    "Please choice one option: ",
                    "Error: Input a digit!",
                    "Error: Choice 1-3!", 1, 3);

            switch (choice) {
                case 1:
                    performNormalCalc(manager);
                    break;
                case 2:
                    performBMICalc(manager);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void performNormalCalc(Manager m) {
        System.out.println("----- Normal Calculator -----");
        double memory = Validation.checkInputDouble("Enter number: ", "Error: Digit only!");

        while (true) {
            Operator op = Validation.checkOperator("Enter Operator: ", "Please input (+, -, *, /, ^, =)");

            if (op == Operator.EQUAL) {
                System.out.println("Result: " + memory);
                break;
            }

            double nextNum = Validation.checkInputDouble("Enter number: ", "Error: Digit only!");
            memory = m.calculate(memory, op, nextNum);
            System.out.println("Memory: " + memory);
        }
    }

    private static void performBMICalc(Manager m) {
        System.out.println("----- BMI Calculator -----");
        double weight, height;

        // Weight must be greater than 0
        while (true) {
            weight = Validation.checkInputDouble("Enter Weight(kg): ", "Error: BMI is digit!");
            if (weight > 0) {
                break;
            }
            System.err.println("Weight must be greater than 0!");
        }

        // Height must be greater than 0
        while (true) {
            height = Validation.checkInputDouble("Enter Height(cm): ", "Error: BMI is digit!");
            if (height > 0) {
                break;
            }
            System.err.println("Height must be greater than 0!");
        }

        BMIStatus status = m.calculateBMI(weight, height);
        System.out.println("BMI Status: " + status);
    }
}
