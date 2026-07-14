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
        final String header;
        switch (choice) {
            case MatrixOperation.ADDITION:
                header = "-------- Addition --------";
                break;
            case MatrixOperation.SUBTRACTION:
                header = "-------- Subtraction --------";
                break;
            case MatrixOperation.MULTIPLICATION:
                header =
                    "-------- Multiplication --------";
                break;
            default:
                return;
        }

        System.out.println(header);

        final int[][] matrix1 =
                inputMatrix(1, null, choice);
        final int[][] matrix2 =
                inputMatrix(2, matrix1, choice);
        final int[][] result =
                computeResult(choice, matrix1, matrix2);

        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(
                MatrixOperation.getSymbol(choice));
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    /**
     * Compute result based on operation type.
     *
     * @param choice operation number
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return computed result
     */
    private int[][] computeResult(
            int choice,
            int[][] matrix1,
            int[][] matrix2) {
        switch (choice) {
            case MatrixOperation.ADDITION:
                return service.additionMatrix(
                        matrix1, matrix2);
            case MatrixOperation.SUBTRACTION:
                return service.subtractionMatrix(
                        matrix1, matrix2);
            case MatrixOperation.MULTIPLICATION:
                return service.multiplicationMatrix(
                        matrix1, matrix2);
            default:
                return new int[0][0];
        }
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
                    "Enter Row Matrix " + matrixIndex
                            + ": ",
                    MessageConstant.MSG_INVALID_NUMBER,
                    MessageConstant.MSG_GREATER_THAN_ZERO
            );
            col = InputValidator.checkInputInt(
                    "Enter Column Matrix " + matrixIndex
                            + ": ",
                    MessageConstant.MSG_INVALID_NUMBER,
                    MessageConstant.MSG_GREATER_THAN_ZERO
            );

            if (prevMatrix == null) {
                isValidSize = true;
            } else if (choice
                    != MatrixOperation.MULTIPLICATION) {
                if (row == prevMatrix.length
                        && col
                        == prevMatrix[0].length) {
                    isValidSize = true;
                } else {
                    System.out.println(
                            MessageConstant
                                    .ERR_SIZE_ADD_SUB);
                }
            } else {
                if (row == prevMatrix[0].length) {
                    isValidSize = true;
                } else {
                    System.out.println(
                            MessageConstant
                                    .ERR_SIZE_MUL);
                }
            }
        }

        final int[][] matrix = new int[row][col];
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
            final StringBuilder sb =
                    new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append("[")
                        .append(matrix[i][j])
                        .append("]");
            }
            System.out.println(sb.toString());
        }
    }
}
