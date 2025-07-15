import java.util.Scanner;

public class BinaryToDecimal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        int binary = 0;

        int temp = decimal;

        while (temp > 0) {
            int rem = temp % 2;
            binary = binary * 10 + rem;
            temp /= 2;
        }

        System.out.println("The binary value of " + decimal + " is: " + binary);

        sc.close();
    }
}
