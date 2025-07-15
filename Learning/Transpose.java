import java.util.Scanner;

public class Transpose {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the rows: ");
        int row = sc.nextInt();

        System.out.print("Enter the columns: ");
        int column = sc.nextInt();

        
        int arr[][] = new int[row][column];

        int transpose[][] = new int[row][column];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter array[" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        System.out.println("After transposing: ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
