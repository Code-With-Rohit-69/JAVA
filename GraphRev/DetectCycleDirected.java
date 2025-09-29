import java.util.ArrayList;

public class DetectCycleDirected {

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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));

    }

    public static boolean dfs(ArrayList<Edge> graph[]) {
        boolean[] vis = new boolean[graph.length];

        boolean[] recStack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false && dfsUtil(graph, i, vis, recStack)) {
                return true;
            }
        }

        return false;

    }

    public static boolean dfsUtil(ArrayList<Edge> graph[], int curr, boolean[] vis, boolean[] recStack) {
        vis[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (recStack[e.des]) {
                return true;
            } else if (!vis[e.des]) {
                dfsUtil(graph, e.des, vis, recStack);
            }
        }

        recStack[curr] = true;

        return false;

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean result = dfs(graph);
        System.out.println(result);

    }
}
