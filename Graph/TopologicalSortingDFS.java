import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {

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

        // 2

        graph[2].add(new Edge(2, 3, 0));

        // 3

        graph[3].add(new Edge(3, 1, 0));

        // 4

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

        // 5

        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, visited, stack, i);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();

    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean[] visited, Stack<Integer> stack, int curr) {

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.des]) {
                dfsUtil(graph, visited, stack, e.des);
            }
        }

        stack.add(curr);

    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
    }
}
