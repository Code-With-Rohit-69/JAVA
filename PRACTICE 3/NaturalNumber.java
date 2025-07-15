import java.util.Scanner;

public class NaturalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int sum = 0;
        int i = 0;

        while (i <= number) {
            sum += i;
            i++ ;
        }


        System.out.println("Sum of natural number is : " + sum);
        System.out.println("value of i is: " + i);

        scanner.close();
    }
}
