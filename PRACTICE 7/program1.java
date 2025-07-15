import java.util.Scanner;

public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a month: ");
        int month = sc.nextInt();
        if (month == 2) {
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 100)) {
                System.out.println("There are 29 days in " + month + " month");
            } else {
                System.out.println("There are 28 days in " + month + " month");
            }
        } else if (month < 8 && month % 2 != 0) {
            System.out.println("There are 31 days in " + month + " month");
        } else if (month < 8 && month % 2 == 0) {
            System.out.println("There are 30 days in " + month + " month");
        } else if (month >= 8 && month % 2 == 0) {
            System.out.println("There are 31 days in " + month + " month");
        } else {
            System.out.println("There are 30 days in " + month + " month");
        }

        sc.close();
    }
}