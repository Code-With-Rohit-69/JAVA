import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class ShortestPathUsingSet {
    static ArrayList<Edge>[] graph;

    public static void createGraph(int[][] edges) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0], des = edge[1], wt = edge[2];
            graph[src].add(new Edge(src, des, wt));
            graph[des].add(new Edge(des, src, wt));
        }

    }

    public static void main(String[] args) {
        int V = 6;
        graph = new ArrayList[V];
        int[][] edge = {
                { 0, 2, 4 },
                { 0, 1, 4 },
                { 1, 2, 2 },
                { 2, 3, 3 },
                { 2, 4, 1 },
                { 2, 5, 6 },
                { 3, 5, 2 },
                { 4, 5, 3 },
        };

        createGraph(edge);

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dis == b.dis) {
                return a.node - b.node;
            }

            return a.dis - b.dis;
        });

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;

        set.add(new Pair(0, 0));

        while (!set.isEmpty()) {
            Pair curr = set.pollFirst();
            int node = curr.node;

            for (Edge e : graph[node]) {

                int adj = e.des;
                int wt = e.wt;

                if (distance[node] + wt < distance[adj]) {

                    set.remove(new Pair(adj, distance[adj]));

                    distance[adj] = distance[node] + wt;

                    set.add(new Pair(adj, distance[adj]));
                }
            }
        }

        // print

        for (int dis : distance) {
            System.out.print(dis + " ");
        }

        System.out.println();

        return;
    }
}

class Edge {
    int src;
    int des;
    int wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.des = d;
        this.wt = w;
    }
}

class Pair {
    int node;
    int dis;

    public Pair(int n, int d) {
        this.node = n;
        this.dis = d;
    }
}