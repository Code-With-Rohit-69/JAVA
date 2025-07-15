import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        int binary = sc.nextInt();

        int decimal = 0;
        int power = 0;

        int temp = binary;

        while (temp > 0) {
            int rem = temp % 10;
            decimal += rem * Math.pow(2, power);
            temp /= 10;
            power++ ;
        }

        System.out.println("The decimal value of " + binary + " is: " + decimal);

        sc.close();
    }
}
