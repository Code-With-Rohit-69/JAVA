import java.util.Arrays;

public class Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int distanceThreshold = 2;

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
            dis[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        for (int[] arr : dis) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dis[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        System.out.println("City with smallest neighbors: " + city);

    }
}
