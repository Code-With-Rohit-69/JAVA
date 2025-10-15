import java.util.*;

public class Dijkstra2 {

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
        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.path - b.path);
        q.add(new Pair(src, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            if (visited[curr.node] == false) {
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.des;
                    int w = e.weight;

                    if (distance[u] + w < distance[v]) {
                        distance[v] = distance[u] + w;
                        q.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }

    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dijkstra(graph, 0);
    }
}
