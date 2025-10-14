import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingBFS {

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

    public static void calculateIndegree(ArrayList<Edge> graph[], int[] indegree) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.des]++;
            }
        }
    }

    public static void topologicalSortingBFS(ArrayList<Edge> graph[]) {
        int[] indegree = new int[graph.length];

        calculateIndegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();

            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                indegree[e.des]--;

                if (indegree[e.des] == 0) {
                    q.add(e.des);
                }
            }
        }

    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topologicalSortingBFS(graph);
    }
}
