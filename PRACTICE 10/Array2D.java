import java.util.Scanner;

public class Array2D{
    public static void getData(int arr[][], Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("Enter the a" + (i+1) + (j+1) + " element: ");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void printData(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("] ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the numbers of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the numbers of columns: ");
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        getData(arr, sc);
        printData(arr);
        
        sc.close();
    }
}