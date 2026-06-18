import java.util.Arrays;
import java.util.HashSet;

public class Count_Distinct_Integers_After_Removing_Zeros {

    long[][][] memo;

    public long dfs(String s, int index, int tight, int leading) {
        if (index == s.length()) {
            return leading;
        }

        if (memo[index][tight][leading] != -1) {
            return memo[index][tight][leading];
        }

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        long ans = 0L;

        for (int i = 0; i <= limit; i++) {
            int newLeading = (leading == 0 && i == 0) ? 0 : 1;
            int newTight = (tight == 1 && i == limit) ? 1 : 0;

            if (newLeading == 0) {
                ans += dfs(s, index + 1, newTight, newLeading);        
            } else {
                if (i == 0) {
                    continue;
                }

                ans += dfs(s, index + 1, newTight, newLeading);
            }
        }

        return memo[index][tight][leading] = ans;

    }

    public long countDistinct(long n) {
        String s = String.valueOf(n);
        int len = s.length();

        memo = new long[len][2][2];

        for (long[][] arr : memo) {
            for (long[] ar : arr) {
                Arrays.fill(ar, -1);
            }
        }

        return dfs(s, 0, 1, 0);
    }

    public void main(String[] args) {
        long n = 92897487392743L;

        long res = countDistinct(n);

        System.out.println(res);

        return;

    }
}
