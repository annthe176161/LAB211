package service;

/**
 * Provides matrix arithmetic operations.
 */
public class MatrixService {

    /**
     * Add two matrices element by element.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return result matrix
     */
    public int[][] additionMatrix(
            int[][] matrix1, int[][] matrix2) {
        validateMatrices(matrix1, matrix2);

        final int row = matrix1.length;
        final int col = matrix1[0].length;
        final int[][] result = new int[row][col];

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
    public int[][] subtractionMatrix(
            int[][] matrix1, int[][] matrix2) {
        validateMatrices(matrix1, matrix2);

        final int row = matrix1.length;
        final int col = matrix1[0].length;
        final int[][] result = new int[row][col];

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
    public int[][] multiplicationMatrix(
            int[][] matrix1, int[][] matrix2) {
        validateMatrices(matrix1, matrix2);

        final int row1 = matrix1.length;
        final int col1 = matrix1[0].length;
        final int col2 = matrix2[0].length;
        final int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] +=
                            matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Check if matrices are valid (not null or empty).
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     */
    private void validateMatrices(
            int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null
                || matrix1.length == 0
                || matrix2.length == 0) {
            throw new IllegalArgumentException(
                    "Matrices must not be null or empty.");
        }
    }
}
