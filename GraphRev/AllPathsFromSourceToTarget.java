import java.util.*;

public class AllPathsFromSourceToTarget {

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

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void dfs(ArrayList<Edge> graph[], List<List<Integer>> ans, List<Integer> list, int src, int des) {
        list.add(src);

        if (src == des) {
            ans.add(new ArrayList<>(list));
        } else {
            for (Edge e : graph[src]) {
                dfs(graph, ans, list, e.des, des);
            }
        }

        list.remove(list.size() - 1);

    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, ans, new ArrayList<>(), 5, 1);

        System.out.println(ans);

    }
}
