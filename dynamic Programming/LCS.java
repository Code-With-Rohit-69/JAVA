public class LCS {

    public static int recursion(String s1, String s2, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            return recursion(s1, s2, m-1, n-1) + 1;
        }

        int firstPart = recursion(s1, s2, m-1, n);
        int secondPart = recursion(s1, s2, m, n-1);

        return Math.max(firstPart, secondPart);
    }

    public static int memoization(String s1, String s2, int m, int n, int[][] dp) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(dp[m][n] != 0) return dp[m][n];

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            dp[m][n] = memoization(s1, s2, m-1, n-1, dp) + 1;
            return dp[m][n];
        }

        int firstPart = memoization(s1, s2, m-1, n, dp);
        int secondPart = memoization(s1, s2, m, n-1, dp);

        return dp[m][n] = Math.max(firstPart, secondPart);
    }
    
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "aceb";

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        int ans = memoization(s1, s2, m, n, dp);

        System.out.println(ans);

    }
}
