import java.util.Scanner;

public class function1{
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter 2nd number: ");
        int num2 = scanner.nextInt();

        int result = sum(num1, num2);
        System.out.println("Sum is : " + result);

        scanner.close();
    }
}