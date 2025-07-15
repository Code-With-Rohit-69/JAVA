import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int div = 2;
        boolean isPrime = true;

        while (num > div) {
            if (num % div == 0) {
                isPrime = false;
                System.out.println("Not Prime");
                break;
            }
            div++;
        }

        if (num > 1 && isPrime) {
            System.out.println("Prime");
        }

        scanner.close();
    }
}
