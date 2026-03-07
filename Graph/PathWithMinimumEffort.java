import java.util.*;

public class PathWithMinimumEffort {

    static int[][] dirs = {
            { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
                { 1, 1, 1, 2, 1 } };

        int m = heights.length, n = heights[0].length;

        int[][] dis = new int[m][n];

        for (int[] arr : dis) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dis[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.diff - b.diff;
        });

        int ans = (int) (1e9);

        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            int i = curr.row, j = curr.col, diff = curr.diff;

            if (diff > dis[i][j]) continue;

            if (i == m - 1 && j == n - 1) {
                ans = diff;
                break; 
            }

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];

                if (x >= 0 && y >= 0 && x < m && y < n) {
                    int newDiff = Math.max(diff, Math.abs(heights[i][j] - heights[x][y]));
                    if (newDiff < dis[x][y]) {
                        dis[x][y] = newDiff;
                        pq.add(new Pair(x, y, newDiff));
                    }
                }

            }

        }

        System.out.println(ans);
        // System.out.println(dis[m - 1][n - 1]);

    }
}

class Pair {
    int row;
    int col;
    int diff;

    public Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.diff = d;
    }
}