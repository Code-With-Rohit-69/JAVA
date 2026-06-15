/*

                                Leetcode 902. Numbers At Most N Given Digit Set

*/

import java.util.*;

public class NumbersAtMostNGivenDigitSet {

    HashSet<Integer> set;
    int[][][] memo;

    public int dfs(String s, int index, int tight, int leading) {
        if (index == s.length()) {
            return leading;
        }

        if (memo[index][tight][leading] != -1)
            return memo[index][tight][leading];

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {

            int newTight = (tight == 1 && i == limit) ? 1 : 0;
            int newLeading = (leading == 0 && i == 0) ? 0 : 1;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, newTight, 0);
            } else {
                if (!set.contains(i)) {
                    continue;
                }

                ans += dfs(s, index + 1, newTight, newLeading);
            }
        }

        return memo[index][tight][leading] = ans;

    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        set = new HashSet<>();

        for (String s : digits) {
            set.add(s.charAt(0) - '0');
        }

        String s = String.valueOf(n);

        memo = new int[s.length()][2][2];

        for (int[][] arr : memo) {
            for (int[] ar : arr) {
                Arrays.fill(ar, -1);
            }
        }

        int res = dfs(s, 0, 1, 0);

        return res;
    }

    public void main(String[] args) {
        // String[] digits = { "1", "3", "5", "7" };
        // int n = 100;

        String[] digits = { "1", "2", "3", "4", "5", "6", "7", "8" };
        int n = 940860624;

        int res = atMostNGivenDigitSet(digits, n);

        System.out.println();

        System.out.println(res);

    }
}
