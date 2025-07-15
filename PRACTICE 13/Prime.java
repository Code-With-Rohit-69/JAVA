import java.util.Scanner;

public class Prime {
    public static boolean isprime(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void printPrimes(int min, int max) {
        System.out.println("Prime numbers between the range " + min + " to " + max + " is: ");
        for (int i = min; i <= max; i++) {
            if (isprime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter minimum number: ");
        int min = sc.nextInt();

        System.out.print("Enter maximum number: ");
        int max = sc.nextInt();


        printPrimes(min, max);

        sc.close();
    }
}
