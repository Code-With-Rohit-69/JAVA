import java.util.Scanner;

public class PrintNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        while (counter <= num) {
            System.out.print(counter + " ");
            counter++;
        }

        scanner.close();
    }
}
