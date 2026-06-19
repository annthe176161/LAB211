/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package biz;

/**
 *
 * @author admin
 */
public enum MatrixOperation {
    ADDITION(1, "+"),
    SUBTRACTION(2, "-"),
    MULTIPLICATION(3, "*"),
    QUIT(4, "");

    private final int choice;
    private final String symbol;

    MatrixOperation(int choice, String symbol) {
        this.choice = choice;
        this.symbol = symbol;
    }

    public int getChoice() {
        return choice;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Resolves an integer choice into the matching Enum value.
     *
     * @param choice the integer input value
     * @return the corresponding MatrixOperation enum element
     */
    public static MatrixOperation fromChoice(int choice) {
        for (MatrixOperation op : MatrixOperation.values()) {
            if (op.getChoice() == choice) {
                return op;
            }
        }
        return QUIT;
    }
}
