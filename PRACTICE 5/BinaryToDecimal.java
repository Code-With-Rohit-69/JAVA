/**
 * BinaryToDecimal
 */
public class BinaryToDecimal {

    public static void binDec(int n) {
        int num = n;
        int pow = 0;
        int dec = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            dec = dec + (lastDigit * (int) Math.pow(2, pow));
            pow++;

            n = n / 10;

        }

        System.out.println("Decimal of " + num + " is: " + dec);
    }

    public static void main(String[] args) {
        binDec(111);
    }
}