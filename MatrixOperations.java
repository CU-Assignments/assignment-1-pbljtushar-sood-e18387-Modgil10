import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix A: ");
        int colsA = scanner.nextInt();

        System.out.println("Enter the number of rows for matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix B: ");
        int colsB = scanner.nextInt();

        if ((rowsA != rowsB || colsA != colsB) && (rowsA != colsB)) {
            System.out.println("Matrix operations cannot be performed due to incompatible dimensions.");
            return;
        }
        int[][] matrixA = new int[rowsA][colsA];
        int[][] matrixB = new int[rowsB][colsB];
        
        System.out.println("Enter elements for matrix A: ");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for matrix B: ");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("Matrix A + Matrix B:");
            printMatrix(addMatrices(matrixA, matrixB, rowsA, colsA));

            System.out.println("Matrix A - Matrix B:");
            printMatrix(subtractMatrices(matrixA, matrixB, rowsA, colsA));
        }

        if (colsA == rowsB) {
            System.out.println("Matrix A * Matrix B:");
            printMatrix(multiplyMatrices(matrixA, matrixB, rowsA, colsA, rowsB, colsB));
        }

        scanner.close();
    }

    public static int[][] addMatrices(int[][] A, int[][] B, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B, int rowsA, int colsA, int rowsB, int colsB) {
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
