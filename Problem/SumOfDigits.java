import java.util.Scanner;

/**
 * SumOfDigits
 */
public class SumOfDigits {

    public static int sumOfDigits(int num) {
        while (num > 9) {
            num = sumDigits(num);
        }

        return num;
    }

    public static int sumDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int r = num % 10;
            sum += r;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = sumOfDigits(num);
        System.out.println("Sum of the digits untill single digit: " + result);

        sc.close();
    }
}