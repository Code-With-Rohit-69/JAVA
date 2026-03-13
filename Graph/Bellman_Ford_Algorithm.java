import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {

    static ArrayList<Edge>[] graph;

    public static void createGraph(int[][] edges, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new Edge(u, v, w));
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 5 },
                { 0, 2, 3 },
                { 1, 2, -2 },
                { 1, 3, 6 },
                { 2, 3, 7 },
                { 3, 1, -3 },
        };

        int V = 4;

        graph = new ArrayList[V];
        createGraph(edges, V);

        int[] distance = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }
        }

        for (int j = 0; j < graph.length; j++) {
            for (Edge e : graph[j]) {
                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    return;
                }
            }
        }

        for (int dis : distance) {
            System.out.print(dis + " ");
        }
    }
}

class Edge {
    int src, des, wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.des = d;
        this.wt = w;
    }
}