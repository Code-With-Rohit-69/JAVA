import java.util.*;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            if (num % 10 == 0) {
                System.out.println("You entered a number which is divisible by 10.");
                break;
            }
            System.out.println(num);
        }

        scanner.close();
    }
}