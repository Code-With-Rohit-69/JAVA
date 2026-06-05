import java.util.Arrays;

public class RangeDigitSum {
    static long target;
    static long[][][] memo;

    public static long dfs(String s, int pos, int sum, int tight) {
        if (sum > target) {
            return 0;
        }

        if (pos == s.length()) {
            return sum == target ? 1 : 0;
        }

        if (memo[pos][sum][tight] != -1) {
            return memo[pos][sum][tight];
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long ans = 0L;

        for (int i = 0; i <= limit; i++) {
            int newTight = (tight == 1 && i == limit) ? 1 : 0;
            ans += dfs(s, pos + 1, sum + i, newTight);
        }

        return memo[pos][sum][tight] = ans;

    }

    public static long solve(long n) {
        String s = String.valueOf(n);
        int len = s.length();

        memo = new long[len][(int) target + 1][2];

        for (long[][] arr : memo) {
            for (long[] a : arr) {
                Arrays.fill(a, -1);
            }
        }

        return dfs(s, 0, 0, 1);

    }
    
    public static void main(String[] args) {
        long num1 = 20, num2 = 110;
        target = 2;

        long c1 = solve(num1 - 1);
        long c2 = solve(num2);

        System.out.println(c2 - c1);

    }
}
