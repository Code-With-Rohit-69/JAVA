import java.util.Scanner;

public class SearchSortedArray {

    // { 1, 2, 3 },
    // { 4, 5, 6 },
    // { 7, 8, 9 }

    public static void search2D(int arr[][], int target) {
        int row = arr.length;
        int column = arr[0].length;

        System.out.println("Length of rows: " + row + " and length of columns: " + column);

        int i = row-1;
        int j = 0;

        while (i >= 0 && j < column) {
            if (arr[i][j] == target) {
                System.out.print(i + " " + j);
                break;
            } else if (arr[i][j] < target) {
                j++;
            } else if (arr[i][j] > target) {
                i--;
            }
        }

    }

    // public static void search2D(int arr[][], int target) {
    // int row = arr.length;
    // int column = arr[0].length;

    // System.out.println("Length of rows: " + row + " and length of columns: " +
    // column);

    // int i = 0;
    // int j = column - 1;

    // while (i < row && j >= 0) {
    // if (arr[i][j] == target) {
    // System.out.print(i + " " + j);
    // break;
    // } else if (arr[i][j] < target) {
    // i++;
    // } else if (arr[i][j] > target) {
    // j--;
    // }
    // }

    // }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        search2D(arr, target);

        sc.close();
    }
}