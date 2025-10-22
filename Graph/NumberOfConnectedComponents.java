import java.util.ArrayList;

public class NumberOfConnectedComponents {

    public static void createGraph(int[][] arr, ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : arr) {    
            graph[e[0]].add(new Edge(e[0], e[1]));
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr) {
        visited[curr] = true;

        for(Edge e : graph[curr]) {
            int v = e.des;

            if (!visited[v]) {
                dfs(graph, visited, v);
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 1 },
                { 1, 3 },
                { 0, 2 },
                { 4, 5 },
                { 7, 8 },
        };

        int V = 9;
        int count = 0;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(arr, graph);

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(graph, visited, i);
                count++;
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