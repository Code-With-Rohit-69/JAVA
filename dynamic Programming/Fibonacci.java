// nth number in fibonacci series

// DP => Optimized Recursion

public class Fibonacci {

    public static int recursion(int n, int[] dp) { // MEMOIZATION
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = recursion(n - 1, dp) + recursion(n - 2, dp);

        return dp[n];

    }

    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n + 1];

        // Tabulation

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

    }
}