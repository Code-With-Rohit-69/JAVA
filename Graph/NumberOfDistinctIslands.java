import java.util.*;

public class NumberOfDistinctIslands {

    static int[][] dirs = {
            { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }
    };

    public static void dfs(int[][] grid, int i, int j, int ith, int jth, int n, int m, ArrayList<String> list,
            boolean[][] visited) {
        String s = toString(i - ith, j - jth);

        list.add(s);

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] == 1) {
                dfs(grid, x, y, ith, jth, n, m, list, visited);
            }
        }

    }

    public static String toString(int r, int c) {
        return Integer.toString(r) + "-" + Integer.toString(c);
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        HashSet<ArrayList<String>> set = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid, i, j, i, j, n, m, list, visited);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };

        // int grid[][] = {
        //         { 1, 1, 0, 1, 1 },
        //         { 1, 0, 0, 0, 0 },
        //         { 0, 0, 0, 0, 1 },
        //         { 1, 1, 0, 1, 1 }
        // };

        int res = countDistinctIslands(grid);

        System.out.println(res);
    }
}