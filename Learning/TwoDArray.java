import java.util.Scanner;

public class TwoDArray {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);

        int arr[][] = {
            {1, 4, 9},
            {11, 4, 3},
            {2, 2, 3}
        };

        int sum = 0;

        System.out.print("Enter the row you want to sum: ");
        int row = sc.nextInt();

        for (int i = 0; i < arr[row-1].length; i++) {
            sum += arr[row-1][i];
        }

        System.out.println("Sum = " + sum);

        sc.close();
    }
}