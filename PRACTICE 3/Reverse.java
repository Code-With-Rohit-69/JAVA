import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 10 to n: ");
        int num = scanner.nextInt();
        int reverse = 0;
        
        while (num != 0) {
            int r = num % 10;
            reverse = reverse * 10 + r;
            num = num / 10;
        }

        System.out.println(reverse);

        scanner.close();
    }
}
