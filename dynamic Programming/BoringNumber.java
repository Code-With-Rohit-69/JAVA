/*
 * A Boring Number is a +ve number if all of the digits at even positions in the
 * number are even and all of the digits at odd positions are odd
 */

import java.util.Arrays;

public class BoringNumber {

    static long[][][][] memo;

    public static long dfs(String s, int pos, int tight, int started, int idx) {
        if (pos == s.length()) {
            return started;
        }

        if (tight == 0 && memo[pos][tight][started][idx] != -1)
            return memo[pos][0][started][idx];

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long ans = 0L;

        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newStarted = (started == 0 && digit == 0) ? 0 : 1;

            if (newStarted == 0) {
                ans += dfs(s, pos + 1, newTight, newStarted, idx);
            } else {
                if ((idx % 2 == 0 && digit % 2 == 1) || (idx % 2 != 0 && digit % 2 == 0)) {
                    ans += dfs(s, pos + 1, newTight, newStarted, idx + 1);
                }
            }

        }

        return memo[pos][0][started][idx] = ans;

    }

    public static long solve(long n) {
        String s = String.valueOf(n);

        int len = s.length();

        memo = new long[len][2][2][len + 1];

        for (long[][][] arr : memo) {
            for (long[][] ar : arr) {
                for (long[] a : ar) {
                    Arrays.fill(a, -1);
                }
            }
        }

        return dfs(s, 0, 1, 0, 0);
    }

    public static void main(String[] args) {
        // long L = 779, R = 783;
        // long L = 120, R = 125;
        long L = 5, R = 15;
        long c1 = solve(L - 1);
        long c2 = solve(R);

        System.out.println(c2 + " " + c1);

        System.out.println(c2 - c1);

    }
}