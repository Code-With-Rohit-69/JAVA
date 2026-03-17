import java.util.*;

public class Kruskals_Algorithm {

    static int V = 7;

    static class Edge implements Comparable<Edge> {
        int src, des, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }

        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    static int[] parent = new int[V];
    static int[] rank = new int[V];

    static void init() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    static int find(int n) {
        if (parent[n] == n)
            return n;

        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(1, 4, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 4, 3));
        edges.add(new Edge(1, 5, 4));
        edges.add(new Edge(3, 4, 5));
        edges.add(new Edge(2, 6, 7));
        edges.add(new Edge(3, 6, 8));
        edges.add(new Edge(4, 5, 9));

        Collections.sort(edges);

        init();

        int cost = 0;

        for (Edge e : edges) {
            if (find(e.des) != find(e.src)) {
                union(e.src, e.des);
                cost += e.wt;
                System.out.println(e.src + " - " + e.des + " : " + e.wt);
            }
        }

        System.out.println("MST Cost = " + cost);
        
        return;

    }
}