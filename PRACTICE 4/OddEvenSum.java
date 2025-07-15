import java.util.*;

public class OddEvenSum{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int even = 0;
        int odd = 0;
        int choice = 1;

        while (choice == 1) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                even += number;
            } else{
                odd += number;
            }

            System.out.print("If you want to enter a new number then press 1 if not then 0: ");
            choice = scanner.nextInt();
        }

        System.out.println("Sum of Even number is: " + even + " and of Odd number is: " + odd);

        scanner.close();
    }
}