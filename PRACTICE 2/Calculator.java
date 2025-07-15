import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st operand: ");
        float num1 = scanner.nextFloat();
        System.out.print("Enter 2nd operand: ");
        float num2 = scanner.nextFloat();

        System.out.print("Now Enter a valid operator: ");
        char ch = scanner.next().charAt(0);

        switch (ch) {
            case '+':
                System.out.println("Sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Subtration of " + num1 + " and " + num2 + " is: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Multiplication of " + num1 + " and " + num2 + " is: " + (num1 * num2));
                break;
            case '/':
                System.out.println("Division of " + num1 + " and " + num2 + " is: " + (num1 / num2));
                break;
            case '%':
                System.out.println("Remainder of " + num1 + " and " + num2 + " is: " + (num1 % num2));
                break;
            default:
                System.out.println("Please enter a valid operation");
                break;
        }

        scanner.close();
    }
}