import java.util.Scanner;

public class SumOfDigits {
    public static void digitSum(int n){
        int temp = n;
        int sum = 0;

        while (n != 0) {
            int r = n % 10;
            sum = sum + r;
            n = n / 10;
        }

        System.out.println("Sum of the " + temp + " digits are: " + sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        digitSum(num);

        sc.close();
    }
}
