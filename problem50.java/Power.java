public class Power {

    public static double myPow(double x, int n) {
        double power = 1;
        int temp = Math.abs(n);

        for(int i = 1; i <= temp; i++) {
            power *= x;
        }

        return n > 0 ? power : 1/power;
    }

    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2;

        double power = Math.pow(x, n);
        System.out.println(power);

        // double result = myPow(x, n);
        // System.out.println(result);
    }
}