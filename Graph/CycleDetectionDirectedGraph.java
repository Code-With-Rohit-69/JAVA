import java.util.ArrayList;

public class CycleDetectionDirectedGraph {

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));

        // 1

        graph[1].add(new Edge(1, 3));

        // 2

        graph[2].add(new Edge(2, 3));


    }

    public static boolean dfs(ArrayList<Edge>[] graph, int V) {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfsUtil(graph, visited, recStack, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, boolean[] visited, boolean[] recStack, int curr) {

        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (recStack[e.des]) {
                return true;
            } else if (!visited[e.des] && dfsUtil(graph, visited, recStack, e.des)) {
                return true;
            }

        }

        recStack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);

        boolean result = dfs(graph, V);
        System.out.println(result);

    }
}
