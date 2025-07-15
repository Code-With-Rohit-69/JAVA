import java.util.Scanner;

public class Power {

    public static double pow(int x, int n) {
        int binaryForm = n;
        double ans = 1;

        while (binaryForm > 0) {
            if (binaryForm % 2 == 1) {
                ans = ans * x;
            }
            x *= x;
            binaryForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        System.out.print("Enter x: ");
        int n = sc.nextInt();

        System.out.println(pow(x, n));

        sc.close();
    }
}