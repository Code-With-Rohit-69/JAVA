import java.util.Scanner;

public class Factorial {
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

    public static int binCoeff(int n, int r) {

        int nFact = factorial(n);
        int rFact = factorial(r);
        int nrFact = factorial(n - r);

        int result = nFact / (rFact * nrFact);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        int r = 2;

        System.out.println(binCoeff(n, r));

        scanner.close();
    }
}
