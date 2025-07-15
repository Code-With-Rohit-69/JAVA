import java.util.Scanner;

public class Pallindrome {

    public static void isPallindrome(int n) {
        int reverse = 0;
        int temp = n;

        while (n != 0) {
            int r = n % 10;
            reverse = (reverse * 10) + r;
            n = n / 10;
        }

        if (reverse == temp) {
            System.out.println(temp + " is an Pallindrome number.");
        } else {
            System.out.println(temp + " is not an Pallindrome number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        isPallindrome(num);
        sc.close();
    }
}
