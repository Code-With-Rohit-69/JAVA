import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String args[]) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the first number
        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        
        // Prompt the user for the second number
        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        
        // Calculate the sum of the two numbers
        int sum = firstNumber + secondNumber;
        
        // Display the result
        System.out.println("The sum of " + firstNumber + " and " + secondNumber + " is " + sum);
        
        // Close the scanner
        scanner.close();
    }
}
