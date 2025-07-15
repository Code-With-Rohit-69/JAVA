import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        int num2 = sc.nextInt();

        int multiply = 0;

        for (int i = 1; i <= num2; i++) {
            multiply += num1;
        }

        System.out.println("THE MULTIPLICATION OF " + num1 + " AND " + num2 + " IS: " + multiply);

        // for (int i = 1; i <= 3; i++) {
        //     while (i > 3) {
        //         i = i + 2;
        //     }
        //     System.out.println(i);
        // }

        sc.close();
    }
}