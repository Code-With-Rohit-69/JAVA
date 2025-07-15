public class HappyNumber {

    public static boolean isHappy(int n) {
        while (n > 9) {
            n = squareSumOfNumber(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    public static int squareSumOfNumber(int n) {
        int sum = 0;

        while (n > 0) {
            int r = n % 10;
            sum += (r * r);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 2;
        boolean result = isHappy(n);
        System.out.println(result);
    }
}
