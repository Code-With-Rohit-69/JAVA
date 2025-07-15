public class NewProblem {
    static String number[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    public static void printDigits(int n) {

        if (n == 0) {
            return;
        }

        int lastDigit = n % 10;
        printDigits(n / 10);
        System.out.print(number[lastDigit] + " ");
    }

    public static void main(String[] args) {
        int n = 7248734;
        printDigits(n);
    }
}