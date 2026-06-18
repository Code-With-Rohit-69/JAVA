import java.util.Arrays;

public class Minimum_cost_to_fill_given_weight_in_a_bag {

    int[][] memo;

    public int dfs(int[] cost, int index, int w) {
        if (w == 0)
            return 0;

        if (w < 0)
            return Integer.MAX_VALUE;

        if (index == cost.length)
            return Integer.MAX_VALUE;

        if (cost[index] == -1) {
            return dfs(cost, index + 1, w);
        }

        if (memo[index][w] != -1) {
            return memo[index][w];
        }

        int take = dfs(cost, index, w - (index + 1));

        if (take != Integer.MAX_VALUE)
            take += cost[index];

        int skip = dfs(cost, index + 1, w);

        return memo[index][w] = Math.min(take, skip);
    }

    public int tabulation(int[] cost, int w) {
        int[][] dp = new int[cost.length + 1][w + 1];
        int n = cost.length;

        int INF = (int) 1e9;

        for (int j = 1; j <= w; j++) {
            dp[n][j] = INF;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                if (cost[i] == -1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    int wt = i + 1;

                    int skip = dp[i + 1][j];
                    int take = INF;

                    if (j >= wt && dp[i][j - wt] != INF) {
                        take = cost[i] + dp[i][j - wt];
                    }

                    dp[i][j] = Math.min(take, skip);
                }
            }
        }

        return dp[0][w];

    }

    public int minimumCost(int[] cost, int w) {
        memo = new int[cost.length][w + 1];

        for (int arr[] : memo) {
            Arrays.fill(arr, -1);
        }

        int res = tabulation(cost, w);
        // int res = dfs(cost, 0, w);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void main(String[] args) {
        int[] cost = { 20, 10, 4, 50, 100 };
        // int[] cost = { -1, -1, 4, 3, -1 };
        int w = 5;

        int res = minimumCost(cost, w);

        System.out.println(res);
    }
}

/*
 * 
 * 20 -> 1
 * 10 -> 2
 * 4 -> 3
 * 50 -> 4
 * 100 -> 5
 * 
 */