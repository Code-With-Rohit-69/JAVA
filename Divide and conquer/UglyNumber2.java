import java.util.ArrayList;

public class UglyNumber2 {

    public static void nthUglyNumber(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            while (i % 2 == 0) {
                arr.add(i);
                i /= 2;
            }
            while (i % 3 == 0) {
                arr.add(i);
                i /= 3;
            }
            while (i % 5 == 0) {
                arr.add(i);
                i /= 5;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int n = 10;
        nthUglyNumber(n);
    }
}
