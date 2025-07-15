import java.util.Scanner;

public class Symmetric {

    public static void SymmetricMatrix(int arr1[][], int arr2[][]) {

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                arr2[i][j] = arr1[j][i];
            }
        }
    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSymmetric(int arr1[][], int arr2[][]) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void setArray(int arr[][], Scanner sc) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("Enter arr[" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void reEnterRowAndColumn(int rows, int columns, Scanner sc) {
        while (rows != columns) {
            System.out.println("# Please enter the same rows and columns.");
            System.out.print("Enter the number of Rows: ");
            rows = sc.nextInt();
            System.out.print("Enter the number of Columns: ");
            columns = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of Columns: ");
        int columns = sc.nextInt();

        if (rows != columns) {
            reEnterRowAndColumn(rows, columns, sc);
        }

        int matrixA[][] = new int[rows][columns];

        setArray(matrixA, sc);

        int matrixB[][] = new int[rows][columns];

        System.out.println("Before Transposing Matrix: ");

        printArray(matrixA);

        SymmetricMatrix(matrixA, matrixB);

        System.out.println("After Transposing Matrix: ");
        printArray(matrixB);

        boolean result = isSymmetric(matrixA, matrixB);

        if (result) {
            System.out.println("Matrix is Symmetric matrix.");
        } else {
            System.out.println("Matrix is non-Symmetric matrix.");
        }

        sc.close();

    }
}