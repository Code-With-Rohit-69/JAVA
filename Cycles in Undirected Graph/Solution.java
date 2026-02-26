import java.util.*;

class Solution {
    public static boolean bfs(int s, ArrayList<ArrayList<Integer>> graph, boolean[] vis, int V) {
        Queue<int[]> q = new java.util.LinkedList<>();
        q.add(new int[] { s, -1 });

        vis[s] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int src = curr[0], parent = curr[1];

            for (int neighbour : graph.get(src)) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(new int[] { neighbour, src });
                } else if (parent != neighbour)
                    return true;
            }
        }

        return false;
    }

    public static boolean bfsUtil(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && bfs(i, graph, vis, V)) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int parent, boolean[] vis) {
        vis[src] = true;

        for (int num : graph.get(src)) {
            if (!vis[num]) {
                if (dfs(graph, num, src, vis)) {
                    return true;
                }
            } else if (parent != num) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(graph, i, -1, vis))
                return true;
        }

        return false;
    }

    public static boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfsUtil(graph, V);
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        int V = 4;
        boolean result = isCycle(V, edges);

        System.out.println(result);
    }
}
