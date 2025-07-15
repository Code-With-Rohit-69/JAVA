import java.util.*;

public class Armstrong {
    public static boolean checkArmstrong(int n) {
        int temp = n;
        int digits = 0;
        int arm = 0;

        while (temp != 0) {
            temp /= 10;
            digits++;
        }

        temp = n;
        while (temp != 0) {
            int r = temp % 10;
            arm += Math.pow(r, digits);
            temp /= 10;
        }

        return arm == n;
    }

    public static void printArms(int n) {
        for (int i = 1; i <= n; i++) {
            if (checkArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        printArms(n);

        sc.close();
    }
}
