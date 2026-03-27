public class Cherry_Pickup_II {

    static int[][] dirs = {
            { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    static int m, n;
    static int[][][] memo;

    public static boolean check(int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n)
            return true;
        return false;
    }

    public static int dfs(int[][] grid, int i, int j1, int j2) {
        if (!check(i, j1) || !check(i, j2))
            return Integer.MIN_VALUE;

        if (memo[i][j1][j2] != -1)
            return memo[i][j1][j2];

        if (i == m - 1) {
            if (j1 == j2) {
                return memo[i][j1][j2] = grid[i][j1];
            }

            return memo[i][j1][j2] = grid[i][j1] + grid[i][j2];
        }

        int cherries = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int next = 0;

                next = dfs(grid, i + 1, j1 + d1, j2 + d2);

                if (next != Integer.MIN_VALUE) {
                    if (j1 == j2) {
                        cherries = Math.max(cherries, next + grid[i][j1]);
                    } else {
                        cherries = Math.max(cherries, next + grid[i][j1] + grid[i][j2]);
                    }
                }
            }
        }

        return memo[i][j1][j2] = cherries;
    }

    public static int tabulation(int[][] grid) {
        int[][][] dp = new int[m][n][n];

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int maxCherries = Integer.MIN_VALUE;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int newJ1 = j1 + d1;
                            int newJ2 = j2 + d2;

                            if (newJ1 >= 0 && newJ1 < n && newJ2 >= 0 && newJ2 < n) {
                                maxCherries = Math.max(maxCherries, dp[i + 1][newJ1][newJ2]);
                            }
                        }
                    }

                    if (j1 == j2)
                        dp[i][j1][j2] = maxCherries + grid[i][j1];
                    else
                        dp[i][j1][j2] = maxCherries + grid[i][j1] + grid[i][j2];

                }
            }
        }

        return dp[0][0][n - 1];

    }

    public static int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        /*
         * 
         * memo = new int[m][n][n];
         * 
         * for(int[][] arr : memo) {
         * for(int[] a : arr) {
         * Arrays.fill(a, -1);
         * }
         * }
         * 
         * int ans = dfs(grid, 0, 0, n - 1); // row, col1, col2
         * 
         * return ans;
         * 
         */

        return tabulation(grid);

    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        
        int res = cherryPickup(grid);
        System.out.println(res);

    }
}