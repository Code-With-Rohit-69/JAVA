public class NumberToString {

    static String number[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    public static void numberToString(int n) {
        if (n == 0) {
            return;
        }

        int lastDigit = n % 10;
        numberToString(n / 10);
        System.out.print(number[lastDigit] + " ");
    }

    public static void main(String[] args) {
        int number = 1973;
        numberToString(number);
    }
}
