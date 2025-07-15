import java.util.Scanner;

public class Fibonacci {

    public static int fib(int n) {
        int num1 = 0, num2 = 1;

        if (n <= 1) {
            return n;
        }

        int num3 = num1 + num2;

        for (int i = 0; i < n-2; i++) {
            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;
        }

        return num3;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println(fib(n));

        sc.close();

        // if(n == 0 || n == 1) {
        //     return n;
        // }
        // return fib(n-1) + fib(n-2);
    }
}
