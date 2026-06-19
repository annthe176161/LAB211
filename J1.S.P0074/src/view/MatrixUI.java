/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import biz.MatrixOperation;
import biz.MatrixServices;
import validation.InputValidator;

/**
 *
 * @author admin
 */
public class MatrixUI {

    private final MatrixServices services = new MatrixServices();

    // Centralized UI Constants for Messages and Errors inside View Layer
    private static final String MSG_INVALID_NUMBER = "Values must be a valid number.";
    private static final String MSG_GREATER_THAN_ZERO = "Value must be greater than 0.";
    private static final String MSG_MATRIX_DIGIT = "Values of matrix must be the number";

    private static final String ERR_SIZE_ADD_SUB = "Error: Matrices must have the same dimensions for addition/subtraction!";
    private static final String ERR_SIZE_MUL = "Error: Rows of Matrix 2 must equal Columns of Matrix 1!";

    /**
     * Displays the primary menu program interface.
     */
    public void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    /**
     * Directs data workflow execution based on the active chosen enum using
     * optimized switch-case.
     *
     * @param operation the selected execution operation mode
     */
    public void performMatrixOperation(MatrixOperation operation) {
        int[][] matrix1 = null;
        int[][] matrix2 = null;
        int[][] result = null;

        // Optimized using switch-case over enum instead of long if-else chain
        switch (operation) {
            case ADDITION:
                System.out.println("-------- Addition --------");
                matrix1 = inputMatrix(1, null, operation);
                matrix2 = inputMatrix(2, matrix1, operation);
                result = services.additionMatrix(matrix1, matrix2);
                break;

            case SUBTRACTION:
                System.out.println("-------- Subtraction ------");
                matrix1 = inputMatrix(1, null, operation);
                matrix2 = inputMatrix(2, matrix1, operation);
                result = services.subtractionMatrix(matrix1, matrix2);
                break;

            case MULTIPLICATION:
                System.out.println("-------- Multiplication --------");
                matrix1 = inputMatrix(1, null, operation);
                matrix2 = inputMatrix(2, matrix1, operation);
                result = services.multiplicationMatrix(matrix1, matrix2);
                break;

            default:
                return;
        }

        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(operation.getSymbol());
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    /**
     * Gathers and confirms dimension constraints for input matrices.
     *
     * @param matrixIndex the index order designation of the current matrix
     * @param previousMatrix reference to the first matrix (null if creating
     * matrix 1)
     * @param op the context operation rule configuration
     * @return a validated multi-dimensional matrix array
     */
    private int[][] inputMatrix(int matrixIndex, int[][] previousMatrix, MatrixOperation op) {
        int row = 0;
        int col = 0;
        boolean isValidSize = false;

        while (isValidSize == false) {
            row = InputValidator.checkInputInt("Enter Row Matrix " + matrixIndex + ": ", MSG_INVALID_NUMBER, MSG_GREATER_THAN_ZERO);
            col = InputValidator.checkInputInt("Enter Column Matrix " + matrixIndex + ": ", MSG_INVALID_NUMBER, MSG_GREATER_THAN_ZERO);

            if (previousMatrix == null) {
                isValidSize = true;
            } else {
                if (op != MatrixOperation.MULTIPLICATION) {
                    if (row == previousMatrix.length && col == previousMatrix[0].length) {
                        isValidSize = true;
                    } else {
                        System.out.println(ERR_SIZE_ADD_SUB);
                    }
                } else {
                    if (row == previousMatrix[0].length) {
                        isValidSize = true;
                    } else {
                        System.out.println(ERR_SIZE_MUL);
                    }
                }
            }
        }

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = InputValidator.checkMatrixValue("Enter Matrix" + matrixIndex + "[" + (i + 1) + "][" + (j + 1) + "]: ", MSG_MATRIX_DIGIT);
            }
        }
        return matrix;
    }

    /**
     * Utility printing function mapping data into bracket style elements
     * format.
     *
     * @param matrix the target matrix grid array to print
     */
    private void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
