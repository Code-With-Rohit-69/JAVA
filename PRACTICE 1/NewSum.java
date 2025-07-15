import java.util.*;

public class NewSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        int product = num1 * num2;

        System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum);
        System.out.println("Product of " + num1 + " and " + num2  + " is " + product);

        sc.close();
    }

}
