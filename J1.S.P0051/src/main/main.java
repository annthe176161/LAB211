package main;

import common.InputHandler;
import constant.AppConstant;
import ui.BMICalculator;
import ui.NormalCalculator;

/**
 * Main entry point for Calculator Program.
 */
public class Main {

    private static final NormalCalculator NORMAL_CALC =
            new NormalCalculator();
    private static final BMICalculator BMI_CALC =
            new BMICalculator();

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "========= Calculator Program =========");
            System.out.println(
                    "1. Normal Calculator");
            System.out.println(
                    "2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = InputHandler.readInt(
                    "Please choice one option: ",
                    "Error: Input a digit!",
                    "Error: Choice 1-3!",
                    AppConstant.MENU_NORMAL_CALC,
                    AppConstant.MENU_EXIT);

            switch (choice) {
                case AppConstant.MENU_NORMAL_CALC:
                    NORMAL_CALC.performCalculation();
                    break;
                case AppConstant.MENU_BMI_CALC:
                    BMI_CALC.performCalculation();
                    break;
                case AppConstant.MENU_EXIT:
                    return;
            }
        }
    }
}
