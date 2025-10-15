import java.util.ArrayList;

public class AllPathsFromSource {

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
        graph[0].add(new Edge(0, 3));

        // 2

        graph[2].add(new Edge(2, 3));

        // 3

        graph[3].add(new Edge(3, 1));

        // 4

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // 5

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void dfs(ArrayList<Edge>[] graph, int src, int des, ArrayList<String> ans, StringBuilder curr) {
        if (src == des) {
            curr.append(src);
            ans.add(curr.toString());
            curr.deleteCharAt(curr.length() - 1);
            return;
        }
        curr.append(src);

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            dfs(graph, e.des, des, ans, curr);

        }

        curr.deleteCharAt(curr.length() - 1);
    }

    public static void main(String[] args) {
        int V = 6;
        int src = 5;
        int des = 1;

        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);

        ArrayList<String> ans = new ArrayList<>();

        dfs(graph, src, des, ans, new StringBuilder());

        System.out.println(ans);

    }
}