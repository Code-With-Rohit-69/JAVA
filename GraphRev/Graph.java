import java.util.*;

public class Graph {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge> graph[], int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.offer(e.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.des] == false) {
                dfs(graph, e.des, visited);
            }
        }
    }

    public static boolean isFound(ArrayList<Edge> graph[], int curr, int target, boolean[] visited) {
        if (curr == target) {
            return true;
        }

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.des] == false && isFound(graph, e.des, target, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void allPaths(ArrayList<Edge> graph[], int src, int target, boolean[] visited, String curr) {
        if (src == target) {
            curr += src;
            System.out.println(curr.toString());
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (visited[e.des] == false) {
                visited[src] = true;
                allPaths(graph, e.des, target, visited, curr + src);
                visited[src] = false;
            }
        }

    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean[] visited = new boolean[graph.length];

        // for (int i = 0; i < V; i++) {
        // if (visited[i] == false) {
        // // bfs(graph, i, visited);
        // dfs(graph, i, visited);
        // }
        // }

        // System.out.println(isFound(graph, 0, 6, visited));
        allPaths(graph, 0, 5, visited, "");

        // for (int i = 0; i < graph[4].size(); i++) {
        // Edge e = graph[4].get(i);
        // System.out.println("Src: " + e.src + ", Dest: " + e.des + ", weight: " +
        // e.wt);
        // }
    }
}