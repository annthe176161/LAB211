package entity;

import constant.DisplayMessages;
import constant.ShapeConstants;

/**
 * Represents a rectangle with a width and a length.
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    /**
     * Creates a rectangle with default dimensions.
     */
    public Rectangle() {
    }

    /**
     * Creates a rectangle with the specified dimensions.
     *
     * @param width width of the rectangle
     * @param length length of the rectangle
     * @throws IllegalArgumentException if width or length is not positive
     */
    public Rectangle(double width, double length) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException(
                    "Width and length must be greater than 0.");
        }
        this.width = width;
        this.length = length;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width new width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Gets the length of the rectangle.
     *
     * @return length of the rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangle.
     *
     * @param length new length of the rectangle
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return area of the rectangle
     */
    @Override
    public double getArea() {
        return this.width * this.length;
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return perimeter of the rectangle
     */
    @Override
    public double getPerimeter() {
        return (this.width + this.length) * ShapeConstants.RECTANGLE_SIDE_COUNT;
    }

    /**
     * Prints the rectangle information.
     */
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.RECTANGLE_HEADER);
        System.out.println(DisplayMessages.LABEL_WIDTH + this.width);
        System.out.println(DisplayMessages.LABEL_LENGTH + this.length);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}
