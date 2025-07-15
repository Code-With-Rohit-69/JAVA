import java.util.*;

public class Binary {

    public static int decimalToBinary(int n) {
        int binary = 0;
        int place = 1;

        while (n > 0) {
            int remainder = n % 2;
            binary = binary + remainder * place;
            n = n / 2;
            place *= 10;
        }

        return binary;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = decimalToBinary(num);
        System.out.println(result);

        sc.close();
    }
}