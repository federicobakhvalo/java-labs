package _1;

import java.util.Random;

public class Part4 {
    public static int[][] createRandomMatrix(int rows, int cols, long seed) {
        Random random = new Random(seed);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // значения 0..99
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void swapMinMaxInRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int minIndex = 0;
            int maxIndex = 0;
            int min = matrix[i][0];
            int max = matrix[i][0];

            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxIndex = j;
                }
            }
            int temp = matrix[i][minIndex];
            matrix[i][minIndex] = matrix[i][maxIndex];
            matrix[i][maxIndex] = temp;
        }
    }


    public static void main (String[] args){
        int[][] matrix = createRandomMatrix(4, 5, 42);

        System.out.println("Сгенерированная матрица:");
        printMatrix(matrix);
        swapMinMaxInRows(matrix);
        System.out.println("\nМатрица после обмена min и max в каждой строке:");
        printMatrix(matrix);
    }
}
