import java.util.Arrays;
import java.util.Scanner;

public class Counting_Numbers {

    static long[][][][] dp;

    public static long dfs(String s, int index, int prev, int used, int tight, int leading) {
        if(index == s.length()) {
            return 1;
        }

        if (dp[index][prev][tight][leading] != -1) {
            return dp[index][prev][tight][leading];
        }

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        long ans = 0L;

        for(int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newLeading = (leading == 0 && digit == 0) ? 0 : 1;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, prev, used, newTight, newLeading);
            } else {
                if (prev == digit) {
                    continue;
                }

                ans += dfs(s, index + 1, digit, used + 1, newTight, newLeading);
            }

        }

        return dp[index][prev][tight][leading] = ans;
    }

    public static long solve(long n) {
        String s = String.valueOf(n);

        dp = new long[s.length()][10][2][2];

        for (long[][][] arr : dp) {
            for (long[][] ar : arr) {
                for (long[] a : ar) {
                    Arrays.fill(a, -1);
                }
            }
        }

        return dfs(s, 0, 0, 0, 1, 0); // string, current index, prev, digits used, tight, leading
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        long c1 = solve(a - 1);
        long c2 = solve(b);

        System.out.println(c2 - c1);

        sc.close();
    }
}
