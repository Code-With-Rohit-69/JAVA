import java.util.Arrays;

public class Leetcode_2827 {

    static int K;
    static int[][][][][][] dp;

    public static int dfs(String s, int index, int odd, int even, int rem, int tight, int leading) {
        if (index == s.length()) {
            return odd == even && rem == 0 ? 1 : 0;
        }

        if(leading == 1 && dp[index][odd][even][rem][tight][leading] != -1) {
            return dp[index][odd][even][rem][tight][leading];
        }

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            int newTight = (tight == 1 && i == limit) ? 1 : 0;
            int newLeading = (leading == 0 && i == 0) ? 0 : 1;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, odd, even, 0, newTight, newLeading);
            } else {
                boolean isEven = (i & 1) == 0;
                int newRem = (rem * 10 + i) % K;

                ans += dfs(s, index + 1, !isEven ? odd + 1 : odd, isEven ? even + 1 : even, newRem, newTight,
                        newLeading);

            }
        }

        if (leading == 1) {
            dp[index][odd][even][rem][tight][leading] = ans;
        }

        return ans;

    }

    public static int solve(int n) {
        String s = String.valueOf(n);

        int len = s.length();

        dp = new int[len][len][len][K][2][2];

        for (int[][][][][] arr : dp) {
            for (int[][][][] ar : arr) {
                for (int[][][] a : ar) {
                    for (int[][] A : a) {
                        for(int[] B : A) {
                            Arrays.fill(B, -1);
                        }
                    }
                }
            }
        }

        return dfs(s, 0, 0, 0, 0, 1, 0);

    }

    public static void main(String[] args) {
        int low = 1, high = 1000000000, k = 19;
        // int low = 10, high = 20, k = 3;
        K = k;

        int c1 = solve(low);
        int c2 = solve(high);

        System.out.println(c2 - c1);
    }
}