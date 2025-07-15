import java.util.Scanner;

public class Matrix {
    public static void print(int rows, int columns, int output[][]) {
        for (int i = 0; i < rows; i++) {
            System.out.print("[ ");
            for (int j = 0; j < columns; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void getdata(int rows, int columns, Scanner sc, int input[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter the value of matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                input[i][j] = sc.nextInt();
            }
        }
    }

    public static void addMatrix(int rows, int columns, int result[][], int matrix1[][], int matrix2[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }

    public static void subMatrix(int rows, int columns, int result[][], int matrix1[][], int matrix2[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int matrix1[][] = new int[rows][columns];
        int matrix2[][] = new int[rows][columns];

        int result[][] = new int[rows][columns];

        System.out.println("MATRIX A: ");
        getdata(rows, columns, sc, matrix1);
        System.out.println("MATRIX B: ");
        getdata(rows, columns, sc, matrix2);

        System.out.println("MATRIX A values: ");
        print(rows, columns, matrix1);
        System.out.println("MATRIX B values: ");
        print(rows, columns, matrix2);

        // Adding the Matrix

        addMatrix(rows, columns, result, matrix1, matrix2);
        
        System.out.println("After the adding the Matrix: ");
        print(rows, columns, result);

        // Subtracting the Matrix

        subMatrix(rows, columns, result, matrix1, matrix2);
        
        System.out.println("After the Subtracting the Matrix: ");
        print(rows, columns, result);

        sc.close();
    }
}