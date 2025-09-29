import java.util.ArrayList;

public class DetectCycleUndirected {

    static class Edge {
        int src;
        int des;

        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 3));

    }

    public static boolean dfs(ArrayList<Edge> graph[]) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                if (dfsUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge> graph[], boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.des]) {
                if (dfsUtil(graph, visited, e.des, curr)) {
                    return true;
                }
            } else if (visited[e.des] && e.des != parent) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean result = dfs(graph);
        System.out.println(result);

    }
}
