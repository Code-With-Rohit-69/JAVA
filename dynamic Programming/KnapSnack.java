import java.util.Arrays;

public class KnapSnack {

    public static int helper(int[] val, int[] wt, int weight, int[][] dp, int n, int index) {

        if (index >= n || weight <= 0) {
            return 0;
        }   

        if (dp[index][weight] != -1) {
            return dp[index][weight];
        }

        int include = 0;
        int exclude = 0;

        if (weight >= wt[index]) {
            include = helper(val, wt, weight - wt[index], dp, n, index + 1) + val[index];
        }

        exclude = helper(val, wt, weight, dp, n, index + 1);

        return dp[index][weight] = Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };

        int W = 7;

        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(helper(val, wt, W, dp, n, 0));

    }
}
