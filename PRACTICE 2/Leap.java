import java.util.Scanner;

public class Leap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if ((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0 ) {
            System.out.println(year + " is an Leap Year");
        }
        else {
            System.out.println(year + " is not an Leap Year");
        }

        scanner.close();
    }
}
