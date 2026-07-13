package main;

import constant.InputMessages;
import entity.Circle;
import entity.Rectangle;
import entity.Triangle;
import util.DataInputHelper;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");

        double width = DataInputHelper.inputPositiveDouble(
                "Please input side width of Rectangle: ",
                InputMessages.ERROR_NOT_A_NUMBER,
                InputMessages.ERROR_NON_POSITIVE
        );
        double length = DataInputHelper.inputPositiveDouble(
                "Please input length of Rectangle: ",
                InputMessages.ERROR_NOT_A_NUMBER,
                InputMessages.ERROR_NON_POSITIVE
        );
        Rectangle rectangle = new Rectangle(width, length);

        double radius = DataInputHelper.inputPositiveDouble(
                "Please input radius of Circle: ",
                InputMessages.ERROR_NOT_A_NUMBER,
                InputMessages.ERROR_NON_POSITIVE
        );
        Circle circle = new Circle(radius);

        double sideA, sideB, sideC;
        while (true) {
            sideA = DataInputHelper.inputPositiveDouble(
                    "Please input side A of Triangle: ",
                    InputMessages.ERROR_NOT_A_NUMBER,
                    InputMessages.ERROR_NON_POSITIVE
            );
            sideB = DataInputHelper.inputPositiveDouble(
                    "Please input side B of Triangle: ",
                    InputMessages.ERROR_NOT_A_NUMBER,
                    InputMessages.ERROR_NON_POSITIVE
            );
            sideC = DataInputHelper.inputPositiveDouble(
                    "Please input side C of Triangle: ",
                    InputMessages.ERROR_NOT_A_NUMBER,
                    InputMessages.ERROR_NON_POSITIVE
            );

            if (Triangle.isValid(sideA, sideB, sideC)) {
                break;
            }
            System.out.println(InputMessages.ERROR_INVALID_TRIANGLE);
        }
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
