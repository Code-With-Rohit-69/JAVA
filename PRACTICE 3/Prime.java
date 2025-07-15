import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int div = 2;
        boolean isPrime = true;

        while (div < Math.sqrt(number)) {
            if (number % div == 0) {
                isPrime = false;
                break;
            }
            div++;
        }

        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }

        scanner.close();
    }
}
