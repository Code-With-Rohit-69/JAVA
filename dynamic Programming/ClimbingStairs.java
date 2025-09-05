public class ClimbingStairs {

    public static int recursion(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = recursion(n - 1, dp) + recursion(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];

        int result = recursion(n, dp);

        System.out.println(result);
    }
}
