/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Circle;
import entity.Rectangle;
import entity.Triangle;
import util.DataInputHelper;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");

        final double width = DataInputHelper.inputPositiveDouble(
                "Please input side width of Rectangle: ",
                "Data input must be a number. Please input again!",
                "Data input must be greater than 0. Please input again!"
        );
        final double length = DataInputHelper.inputPositiveDouble(
                "Please input length of Rectangle: ",
                "Data input must be a number. Please input again!",
                "Data input must be greater than 0. Please input again!"
        );
        Rectangle rectangle = new Rectangle(width, length);

        final double radius = DataInputHelper.inputPositiveDouble(
                "Please input radius of Circle: ",
                "Data input must be a number. Please input again!",
                "Data input must be greater than 0. Please input again!"
        );
        Circle circle = new Circle(radius);

        double sideA, sideB, sideC;
        while (true) {
            sideA = DataInputHelper.inputPositiveDouble(
                    "Please input side A of Triangle: ",
                    "Data input must be a number. Please input again!",
                    "Data input must be greater than 0. Please input again!"
            );
            sideB = DataInputHelper.inputPositiveDouble(
                    "Please input side B of Triangle: ",
                    "Data input must be a number. Please input again!",
                    "Data input must be greater than 0. Please input again!"
            );
            sideC = DataInputHelper.inputPositiveDouble(
                    "Please input side C of Triangle: ",
                    "Data input must be a number. Please input again!",
                    "Data input must be greater than 0. Please input again!"
            );

            if (Triangle.isValid(sideA, sideB, sideC)) {
                break;
            }
            System.out.println("These sides do not form a valid triangle! Please re-input all 3 sides.");
        }
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
