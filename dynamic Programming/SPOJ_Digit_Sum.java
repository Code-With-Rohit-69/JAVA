import java.util.Arrays;
import java.util.Scanner;

public class SPOJ_Digit_Sum {

    static long[][][][] dp;

    public static long dfs(String s, int index, int sum, int tight, int leading) {
        if (index == s.length()) {
            return sum;
        }

        if (dp[index][sum][tight][leading] != -1) {
            return dp[index][sum][tight][leading];
        }

        long ans = 0L;

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;

        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newLeading = (leading == 0 && digit == 0) ? 0 : 1;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, sum, newTight, newLeading);
            } else {
                ans += dfs(s, index + 1, sum + digit, newTight, newLeading);
            }

        }

        return dp[index][sum][tight][leading] = ans;
    }

    public static long solve(long n) {
        String s = String.valueOf(n);
        int len = s.length();

        dp = new long[len][197][2][2];

        for (long[][][] arr : dp) {
            for (long[][] ar : arr) {
                for (long[] a : ar) {
                    Arrays.fill(a, -1);
                }
            }
        }

        return dfs(s, 0, 0, 1, 0); // string, index, tight, leading zero

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            long a = sc.nextLong();
            long b = sc.nextLong();

            long s1 = solve(a - 1);
            long s2 = solve(b);

            System.out.println(s2 - s1);
        }

        // long a = 1234, b = 56789;
        // long a = 28, b = 31;

        sc.close();

    }
}
