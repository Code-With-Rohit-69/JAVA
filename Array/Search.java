import java.util.Scanner;

public class Search {

    public static boolean searchMatrix(int arr[][], int target) {
        int row = arr.length;
        int column = arr[0].length;

        int i = 0;
        int j = column - 1;

        while (i < row && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int row = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int column = sc.nextInt();

        // int arr[][] = new int[row][column];
        int arr[][] = {
                { 11, 14, 17 },
                { 13, 19, 20 },
                { 24, 28, 40 }
        };

        System.out.print("Enter the target number: ");
        int target = sc.nextInt();

        int i = 0;
        int j = column - 1;

        while (i < row && j >= 0) {
            if (arr[i][j] == target) {
                System.out.println("Target " + target + " is found on index number " + i + " " + j);
                break;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        boolean result = searchMatrix(arr, target);
        System.out.println(result);

        sc.close();
    }
}
