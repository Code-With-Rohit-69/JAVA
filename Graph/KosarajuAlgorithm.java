import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0

        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));

        // 1

        graph[1].add(new Edge(1, 0));

        // 2

        graph[2].add(new Edge(2, 1));

        // 3

        graph[3].add(new Edge(3, 4));
    }

    public static void transpose(ArrayList<Edge>[] graph, ArrayList<Edge>[] adj) {

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                int u = e.src;
                int v = e.des;

                adj[v].add(new Edge(v, u));
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> stack, int curr) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.des]) {
                dfs(graph, visited, stack, e.des);
            }
        }

        stack.push(curr);
    }

    public static void dfsSCC(ArrayList<Edge>[] adj, boolean[] visited, int curr) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Edge e : adj[curr]) {
            if (!visited[e.des]) {
                dfsSCC(adj, visited, e.des);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph, V);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(graph, visited, stack, i);
            }
        }

        ArrayList<Edge>[] adj = new ArrayList[V];

        transpose(graph, adj);

        visited = new boolean[V];

        int count = 0;

        while (!stack.isEmpty()) {
            int elem = stack.pop();

            if (!visited[elem]) {
                dfsSCC(adj, visited, elem);
                count++;
                System.out.println();
            }
        }

        System.out.println(count);

    }
}

class Edge {
    int src;
    int des;

    public Edge(int src, int des) {
        this.src = src;
        this.des = des;
    }
}