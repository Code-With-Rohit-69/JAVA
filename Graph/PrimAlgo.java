import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgo {

    @SuppressWarnings("unchecked")
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

        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        boolean[] visited = new boolean[n];
        int sum = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int vertex = curr.vertex, cost = curr.cost;

            if (visited[vertex])
                continue;

            visited[vertex] = true;

            sum += cost;

            for (Edge e : graph[vertex]) {
                int u = e.src, v = e.des, w = e.wt;
                pq.add(new Pair(v, w));
            }
        }

        System.out.println(sum);

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

class Pair {
    int vertex;
    int cost;

    public Pair(int v, int c) {
        this.vertex = v;
        this.cost = c;
    }
}
