package main;

import constant.DisplayMessages;
import constant.InputMessages;
import entity.Circle;
import entity.Rectangle;
import entity.Triangle;
import util.DataInputHelper;

public class Main {

    public static void main(String[] args) {
        System.out.println(DisplayMessages.PROGRAM_TITLE);

        final double width = inputShapeValue(
                InputMessages.PROMPT_RECTANGLE_WIDTH);
        final double length = inputShapeValue(
                InputMessages.PROMPT_RECTANGLE_LENGTH);
        final Rectangle rectangle = new Rectangle(width, length);

        final double radius = inputShapeValue(
                InputMessages.PROMPT_CIRCLE_RADIUS);
        final Circle circle = new Circle(radius);

        final Triangle triangle = inputTriangle();

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    /**
     * Reads a positive double value from the user.
     *
     * @param prompt message displayed before input
     * @return a valid positive decimal number
     */
    private static double inputShapeValue(String prompt) {
        return DataInputHelper.inputPositiveDouble(
                prompt,
                InputMessages.ERROR_NOT_A_NUMBER,
                InputMessages.ERROR_NON_POSITIVE);
    }

    /**
     * Reads three sides from the user and validates triangle inequality.
     *
     * @return a valid Triangle instance
     */
    private static Triangle inputTriangle() {
        while (true) {
            final double sideA = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_A);
            final double sideB = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_B);
            final double sideC = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_C);

            if (Triangle.isValid(sideA, sideB, sideC)) {
                return new Triangle(sideA, sideB, sideC);
            }
            System.out.println(InputMessages.ERROR_INVALID_TRIANGLE);
        }
    }
}
