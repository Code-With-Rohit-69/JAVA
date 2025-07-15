import java.util.Scanner;

public class PascalTriangle {

    public static void pascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            // gaps
            for (int j = 0; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                // System.out.print("* ");
                if (i == 0 || i == j || j == 0) {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        pascalTriangle(rows);

        sc.close();
    }
}
