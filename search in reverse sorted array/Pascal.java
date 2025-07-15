import java.util.Scanner;

public class Pascal{

    public static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static int nCr(int n, int r) {
        int factN = factorial(n);
        int factNmR = factorial(n-r);
        int factR = factorial(r);

        int output = factN / (factNmR * factR);

        return output;
    }

    public static void PascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n-i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                int indexNumber = nCr(i, j);
                System.out.print(indexNumber + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        PascalTriangle(rows);

        sc.close();
    }
}
