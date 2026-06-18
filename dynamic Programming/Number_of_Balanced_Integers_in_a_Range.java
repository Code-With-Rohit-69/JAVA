import java.util.Arrays;

public class Number_of_Balanced_Integers_in_a_Range {

    long[][][][][] memo;
    int handleNegDiff = 80;

    public long dfs(String s, int index, int len, int diff, int tight, int leading) {
        if (index == s.length()) {
            return len > 1 && diff == 0 && leading == 1 ? 1 : 0;
        }

        if (memo[index][len][diff + handleNegDiff][tight][leading] != -1) {
            return memo[index][len][diff + handleNegDiff][tight][leading];
        }

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        long ans = 0L;

        for (int i = 0; i <= limit; i++) {
            int newLeading = (leading == 0 && i == 0) ? 0 : 1;
            int newTight = (tight == 1 && i == limit) ? 1 : 0;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, len, diff, newTight, newLeading);
            } else {

                int newDiff = diff + ((len % 2 == 0) ? i : -i);
                ans += dfs(s, index + 1, len + 1, newDiff, newTight, newLeading);

            }
        }

        return memo[index][len][diff + handleNegDiff][tight][leading] = ans;

    }

    public long countBalanced(long n) {
        if (n <= 10) {
            return 0L;
        }

        String s = String.valueOf(n);
        int len = s.length();

        memo = new long[len][len + 1][160][2][2];

        for (long[][][][] A : memo) {
            for (long[][][] B : A) {
                for (long[][] C : B) {
                    for (long[] D : C) {
                        Arrays.fill(D, -1);
                    }
                }
            }
        }

        return dfs(s, 0, 0, 0, 1, 0);

    }

    public void main(String[] args) {
        long low = 11L;
        long high = 99999999999999L;

        // long low = 100L;
        // long high = 1000000000000000L;

        long c1 = countBalanced(low - 1);
        long c2 = countBalanced(high);

        System.out.println("c1: " + c1 + " c2: " + c2);

        System.out.println(c2 - c1);

        return;

    }
}

/*
 * 
 * time -> 15 * 15 * 127 * 127 * 2 * 2
 * 
 */