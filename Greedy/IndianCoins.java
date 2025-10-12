import java.util.Arrays;

public class IndianCoins {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int V = 4000;

        Arrays.sort(coins);

        int count = 0;

        for (int i = coins.length - 1; i >= 0 && V != 0; i--) {
            while (coins[i] <= V) {
                count++;
                V -= coins[i];
            }
        }

        System.out.println(count);

    }
}
