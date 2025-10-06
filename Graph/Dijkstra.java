import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Edge {
        int src;
        int des;
        int weight;

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // 2

        graph[2].add(new Edge(2, 4, 3));

        // 3

        graph[3].add(new Edge(3, 5, 1));

        // 4

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair {
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int n = graph.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.path - b.path;
        });

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        for(int i = 0; i < n; i++) {
            if(i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.weight;

                    if (distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        // printing

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0);

    }
}