/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biz;

/**
 *
 * @author admin
 */
public class MatrixServices {

    /**
     * Calculates the addition sum of two matching matrices.
     *
     * @param matrix1 the first operand matrix
     * @param matrix2 the second operand matrix
     * @return a new 2D array containing the summation matrix result
     */
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * Calculates the subtraction difference between two matching matrices.
     *
     * @param matrix1 the matrix to subtract from
     * @param matrix2 the matrix being subtracted
     * @return a new 2D array containing the difference matrix result
     */
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    /**
     * Calculates the multiplication product of two dimensions-compliant
     * matrices.
     *
     * @param matrix1 the first multiplier matrix
     * @param matrix2 the second multiplicand matrix
     * @return a new 2D array containing the product matrix result
     */
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] = result[i][j] + (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }
        return result;
    }
}
