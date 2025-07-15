import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the " + (i+1) + " number: ");
            int num = scanner.nextInt();

            if (num % 2 == 0) { //EVEN NUMBER
                evenSum += num;
            } else { // ODD NUMBER
                oddSum += num;
            }
        }

        System.out.println("Sum of Even Numbers is : " + evenSum);
        System.out.println("Sum of Odd Numbers is : " + oddSum);

        scanner.close();
    }
}
