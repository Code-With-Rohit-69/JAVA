import java.util.*;

public class Natural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number which from you want to find the sum: ");
        int num = scanner.nextInt();

        int sum = 0;
        int i = 1;
        while (i <= num) {
            sum += i;
            i++;
        }

        System.out.println("Sum is " + sum);

        scanner.close();
    }
}