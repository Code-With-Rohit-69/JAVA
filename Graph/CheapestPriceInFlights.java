import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestPriceInFlights {

    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int src = flight[0];
            int des = flight[1];
            int wt = flight[2];

            graph[src].add(new Edge(src, des, wt));
        }
    }

    public static void main(String[] args) {
        // int[][] flights = {
        // { 0, 1, 100 },
        // { 1, 2, 100 },
        // { 2, 0, 100 },
        // { 1, 3, 600 },
        // { 2, 3, 200 }
        // };

        // int[][] flights = {
        // { 0, 1, 100 },
        // { 1, 2, 100 },
        // { 0, 2, 500 }
        // };

        int[][] flights = {
                { 1, 0, 5 }, { 2, 1, 5 }, { 3, 0, 2 }, { 1, 3, 2 }, { 4, 1, 1 }, { 2, 4, 1 }
        };

        int V = 5;

        int src = 2, dst = 0, k = 2;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph, flights, V);

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();
            int vertex = curr.vertex;

            if (!visited[vertex]) {
                visited[vertex] = true;

                int stop = curr.stops;
                int cost = curr.cost;

                for (Edge e : graph[vertex]) {
                    int u = e.src;
                    int v = e.des;
                    int w = e.wt;

                    if (distance[u] + w < distance[v] && stop <= k) {
                        distance[v] = distance[u] + w;
                        q.add(new Info(v, cost + w, stop + 1));
                    }
                }
            }
        }

        System.out.println("Distance: " + distance[dst]);

    }
}

class Edge {
    int src;
    int des;
    int wt;

    public Edge(int src, int des, int wt) {
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}

class Info {
    int vertex;
    int cost;
    int stops;

    public Info(int vertex, int cost, int stops) {
        this.vertex = vertex;
        this.cost = cost;
        this.stops = stops;
    }
}