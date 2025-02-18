import java.util.*;
public class ques13 {
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat2[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < mat1[0].length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] transposeMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = mat[i][j];
            }
        }
        return result;
    }
    public static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }
    public static int determinant3x3(int[][] mat) {
        return mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]) 
             - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0]) 
             + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
    }
    public static double[][] inverse2x2(int[][] mat) {
        int det = determinant2x2(mat);
        if (det == 0) return null;
        double[][] inverse = new double[2][2];
        inverse[0][0] = mat[1][1] / (double)det;
        inverse[0][1] = -mat[0][1] / (double)det;
        inverse[1][0] = -mat[1][0] / (double)det;
        inverse[1][1] = mat[0][0] / (double)det;
        return inverse;
    }
    public static double[][] inverse3x3(int[][] mat) {
        int det = determinant3x3(mat);
        if (det == 0) return null;
        double[][] inverse = new double[3][3];
        inverse[0][0] = (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]) / (double)det;
        inverse[0][1] = (mat[0][2] * mat[2][1] - mat[0][1] * mat[2][2]) / (double)det;
        inverse[0][2] = (mat[0][1] * mat[1][2] - mat[0][2] * mat[1][1]) / (double)det;
        inverse[1][0] = (mat[1][2] * mat[2][0] - mat[1][0] * mat[2][2]) / (double)det;
        inverse[1][1] = (mat[0][0] * mat[2][2] - mat[0][2] * mat[2][0]) / (double)det;
        inverse[1][2] = (mat[0][2] * mat[1][0] - mat[0][0] * mat[1][2]) / (double)det;
        inverse[2][0] = (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]) / (double)det;
        inverse[2][1] = (mat[0][1] * mat[2][0] - mat[0][0] * mat[2][1]) / (double)det;
        inverse[2][2] = (mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]) / (double)det;
        return inverse;
    }
    public static void displayMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void displayMatrix(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat1 = createRandomMatrix(3, 3);
        int[][] mat2 = createRandomMatrix(3, 3);
        System.out.println("Matrix 1:");
        displayMatrix(mat1);
        System.out.println("Matrix 2:");
        displayMatrix(mat2);
        System.out.println("\nMatrix Addition:");
        displayMatrix(addMatrices(mat1, mat2));
        System.out.println("\nMatrix Subtraction:");
        displayMatrix(subtractMatrices(mat1, mat2));
        System.out.println("\nMatrix Multiplication:");
        displayMatrix(multiplyMatrices(mat1, mat2));
        System.out.println("\nMatrix Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(mat1));
        System.out.println("\nDeterminant of Matrix 1:");
        System.out.println(determinant3x3(mat1));
        System.out.println("\nInverse of Matrix 1:");
        double[][] inv1 = inverse3x3(mat1);
        displayMatrix(inv1);
        System.out.println("\nInverse of Matrix 2:");
        double[][] inv2 = inverse3x3(mat2);
        displayMatrix(inv2);
    }
}
