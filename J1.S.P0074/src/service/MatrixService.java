package service;

import constant.MatrixOperation;

/**
 * Provides matrix arithmetic operations and
 * business rule validation.
 */
public class MatrixService {

    /**
     * Compute result based on operation type.
     *
     * @param choice operation number
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return computed result
     */
    public int[][] computeResult(
            int choice,
            int[][] matrix1,
            int[][] matrix2) {
        switch (choice) {
            case MatrixOperation.ADDITION:
                return additionMatrix(
                        matrix1, matrix2);
            case MatrixOperation.SUBTRACTION:
                return subtractionMatrix(
                        matrix1, matrix2);
            case MatrixOperation.MULTIPLICATION:
                return multiplicationMatrix(
                        matrix1, matrix2);
            default:
                return new int[0][0];
        }
    }

    /**
     * Check if matrix dimensions are compatible
     * for the given operation.
     *
     * @param choice operation number
     * @param row row count of second matrix
     * @param col column count of second matrix
     * @param prevMatrix first matrix for reference
     * @return true if dimensions are valid
     */
    public boolean isValidDimension(
            int choice,
            int row,
            int col,
            int[][] prevMatrix) {
        if (prevMatrix == null) {
            return true;
        }
        if (choice != MatrixOperation.MULTIPLICATION) {
            return row == prevMatrix.length
                    && col == prevMatrix[0].length;
        } else {
            return row == prevMatrix[0].length;
        }
    }

    /**
     * Add two matrices element by element.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return result matrix
     */
    private int[][] additionMatrix(
            int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] =
                        matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * Subtract matrix2 from matrix1 element by element.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return result matrix
     */
    private int[][] subtractionMatrix(
            int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] =
                        matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * Multiply two matrices using dot product.
     *
     * @param matrix1 first matrix (m x n)
     * @param matrix2 second matrix (n x p)
     * @return result matrix (m x p)
     */
    private int[][] multiplicationMatrix(
            int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] +=
                            matrix1[i][k]
                                    * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
