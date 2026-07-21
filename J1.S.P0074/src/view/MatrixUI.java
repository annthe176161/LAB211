package view;

import constant.MessageConstant;
import constant.MatrixOperation;
import service.MatrixService;
import validation.InputValidator;

/**
 * Handles all user interface for matrix operations.
 */
public class MatrixUI {

    private final MatrixService service =
            new MatrixService();

    /**
     * Display the main menu.
     */
    public void displayMenu() {
        System.out.println(
                "=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    /**
     * Run matrix operation based on user choice.
     *
     * @param choice selected operation number
     */
    public void performMatrixOperation(int choice) {
        String header = getHeader(choice);
        System.out.println(header);

        int[][] matrix1 =
                inputMatrix(1, null, choice);
        int[][] matrix2 =
                inputMatrix(2, matrix1, choice);
        int[][] result =
                service.computeResult(
                        choice, matrix1, matrix2);

        displayResult(matrix1, choice, matrix2,
                result);
    }

    /**
     * Get header string for the selected operation.
     *
     * @param choice operation number
     * @return header string
     */
    private String getHeader(int choice) {
        switch (choice) {
            case MatrixOperation.ADDITION:
                return "-------- Addition --------";
            case MatrixOperation.SUBTRACTION:
                return "-------- Subtraction --------";
            case MatrixOperation.MULTIPLICATION:
                return "-------- Multiplication --------";
            default:
                return "";
        }
    }

    /**
     * Display the operation result in standard format.
     *
     * @param matrix1 first matrix
     * @param choice operation number
     * @param matrix2 second matrix
     * @param result computed result
     */
    private void displayResult(
            int[][] matrix1,
            int choice,
            int[][] matrix2,
            int[][] result) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(
                MatrixOperation.getSymbol(choice));
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    /**
     * Input matrix from user with dimension validation.
     *
     * @param matrixIndex 1 or 2
     * @param prevMatrix first matrix (null for matrix1)
     * @param choice operation number
     * @return validated matrix
     */
    private int[][] inputMatrix(
            int matrixIndex,
            int[][] prevMatrix,
            int choice) {
        int row = 0;
        int col = 0;
        boolean isValidSize = false;

        while (!isValidSize) {
            row = InputValidator.checkInputInt(
                    MessageConstant.MIN_SIZE,
                    "Enter Row Matrix " + matrixIndex
                            + ": ",
                    MessageConstant.MSG_INVALID_NUMBER,
                    MessageConstant.MSG_GREATER_THAN_ZERO
            );
            col = InputValidator.checkInputInt(
                    MessageConstant.MIN_SIZE,
                    "Enter Column Matrix " + matrixIndex
                            + ": ",
                    MessageConstant.MSG_INVALID_NUMBER,
                    MessageConstant.MSG_GREATER_THAN_ZERO
            );

            isValidSize = service.isValidDimension(
                    choice, row, col, prevMatrix);
            if (!isValidSize) {
                printDimensionError(choice);
            }
        }

        return readMatrix(matrixIndex, row, col);
    }

    /**
     * Print error message based on operation type.
     *
     * @param choice operation number
     */
    private void printDimensionError(int choice) {
        if (choice != MatrixOperation.MULTIPLICATION) {
            System.out.println(
                    MessageConstant.ERR_SIZE_ADD_SUB);
        } else {
            System.out.println(
                    MessageConstant.ERR_SIZE_MUL);
        }
    }

    /**
     * Read matrix values from user input.
     *
     * @param matrixIndex 1 or 2
     * @param row row count
     * @param col column count
     * @return filled matrix
     */
    private int[][] readMatrix(
            int matrixIndex,
            int row,
            int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] =
                        InputValidator.checkMatrixValue(
                            "Enter Matrix" + matrixIndex
                                + "[" + (i + 1) + "]["
                                + (j + 1) + "]: ",
                            MessageConstant
                                    .MSG_MATRIX_DIGIT
                        );
            }
        }
        return matrix;
    }

    /**
     * Print matrix in bracket format.
     *
     * @param matrix matrix to print
     */
    private void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb =
                    new StringBuilder();
            for (int j = 0;
                    j < matrix[i].length; j++) {
                sb.append("[")
                        .append(matrix[i][j])
                        .append("]");
            }
            System.out.println(sb.toString());
        }
    }
}
