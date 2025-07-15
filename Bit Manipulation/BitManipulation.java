import java.util.Scanner;

public class BitManipulation {
    public static void swap(int num1, int num2) {
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("After swapping, num1 = " + num1 + " and num2 = " + num2);
    }

    public static void swapByBit(int num1, int num2){
        System.out.println("Before swapping, num1 = " + num1 + " and num2 = " + num2);

        num1 = num1 ^ num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("After swapping, num1 = " + num1 + " and num2 = " + num2);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.print(5 & 6);
        // System.out.print(5 ^ 6);
        // System.out.println(~5);
        // System.out.println(~0);

        // System.out.print("Enter a number: ");
        // int x = sc.nextInt();

        // System.out.println(x^x);

        // swap(10, 20);

        // System.out.println(36 >> 2);

        // System.out.print("Enter a number: ");
        // int num = sc.nextInt();

        // int result = num & 1;

        // if (result == 0) {
        //     System.out.println(num + " is an even number.");
        // } else {
        //     System.out.println(num + " is an odd number");
        // }

        swapByBit(5, 10);

        sc.close();
    }
}