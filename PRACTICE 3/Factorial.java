import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");;
        int num = scanner.nextInt();

        int fact = 1;
        int i = 1;
        if (num > 0) {
            while (i <= num) {
                fact *= i;
                i++ ;
            }
            System.out.println("Factorial for " + num + " numbers is: " + fact);
        } else{
            System.out.println("Please! enter a valid number");
        }

        scanner.close();
    }
}
