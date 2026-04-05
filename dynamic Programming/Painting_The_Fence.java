import java.util.*;

public class Painting_The_Fence {

    public static int dfs(int c, int n, int k, int prev, int prevprev, int[][][] memo) {
        if (c == n)
            return 1;

        if (memo[c][prev + 1][prevprev + 1] != -1) {
            System.out.println("Called");
            return memo[c][prev + 1][prevprev + 1];
        }

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (i == prev && prev == prevprev)
                continue;

            count += dfs(c + 1, n, k, i, prev, memo);

        }

        return memo[c][prev + 1][prevprev + 1] = count;

    }

    public static int countWaysRecur(int n, int k, int[] memo) {

        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        if (memo[n] != -1)
            return memo[n];

        int cnt1 = countWaysRecur(n - 1, k, memo) * (k - 1);

        int cnt2 = countWaysRecur(n - 2, k, memo) * (k - 1);

        return memo[n] = cnt1 + cnt2;
    }

    public static void main(String[] args) {
        int n = 300, k = (int) (1e5);
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int res = countWaysRecur(n, k, memo);
        System.out.println(res);

        // int[][][] memo = new int[n][k + 1][k + 1];

        // for (int[][] arr : memo) {
        //     for (int[] a : arr) {
        //         Arrays.fill(a, -1);
        //     }
        // }

        // int res = dfs(0, n, k, -1, -1, memo);
        // System.out.println(res);
    }
}


