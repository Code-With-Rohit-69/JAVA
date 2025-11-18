import java.util.*;

public class Bipartite2 {

    public static boolean isBipartite(int V, int[][] edges) {

        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];

            graph[src].add(new Edge(src, des));
        }

        int[] visited = new int[V];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == -1) {
                q.add(i);
                visited[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (Edge e : graph[curr]) {
                        int u = e.src;
                        int v = e.des;

                        if (visited[v] != -1 && visited[v] == visited[u])
                            return false;

                        q.add(v);
                        visited[v] = visited[u] == 0 ? 1 : 0;
                    }

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // int V = 3;
        // int E = 2;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // };

        int V = 4;
        int[][] edges = {
                { 0, 3 }, { 1, 2 }, { 3, 2 }, { 0, 2 }
        };

        System.out.println(isBipartite(V, edges));
    }
}

class Edge {
    int src;
    int des;

    public Edge(int s, int d) {
        this.src = s;
        this.des = d;
    }
}