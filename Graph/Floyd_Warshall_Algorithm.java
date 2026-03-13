// multi-source shortest path 
// detect negative cycles

import java.util.Arrays;

public class Floyd_Warshall_Algorithm {
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 2, 2 },
                { 0, 1, 6 },
                { 0, 3, 4 },
                { 3, 1, 1 },
                { 2, 1, 3 },
                { 2, 4, 1 },
                { 4, 1, 1 },
        };

        int n = 5;

        int[][] dis = new int[n][n];

        for (int[] arr : dis) {
            Arrays.fill(arr, (int) (1e9));
        }

        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dis[u][v] = w;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                }
            }
        }

        // printing

        for(int[] arr : dis) {
            for(int num : arr) {
                System.out.print(num == (int) (1e9) ? "INF " : num  + " ");
            }
            System.out.println();
        }

    }
}