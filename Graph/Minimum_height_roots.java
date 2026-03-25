import java.util.*;

public class Minimum_height_roots {

    static ArrayList<ArrayList<Integer>> graph;
    static HashMap<Integer, Integer> map;
    static boolean[] vis;
    static int[] indegree;

    public static int findHeight(int src) {
        int height = 0;
        vis[src] = true;

        for (int neigh : graph.get(src)) {
            if (!vis[neigh]) {
                height = Math.max(findHeight(neigh) + 1, height);
            }
        }

        return height;
    }

    public static ArrayList<Integer> minHeightRoot(int V, ArrayList<ArrayList<Integer>> graph) {
        map = new HashMap<>();
        vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            vis = new boolean[V];
            int height = findHeight(i);
            map.put(i, height);
        }

        int min = (int) (1e9);

        for (int value : map.values()) {
            min = Math.min(value, min);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == min) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static ArrayList<Integer> minHeightRoot_optimized(int V, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 1) {
                q.add(i);
            }
        }

        int remainingNodes = V;

        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int curr = q.remove();

                for (int neigh : graph.get(curr)) {
                    indegree[neigh]--;
                    if (indegree[neigh] == 1) {
                        q.add(neigh);
                    }
                }
            }
        }

        while (q.size() > 0) {
            ans.add(q.remove());
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 5;
        // int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int edges[][] = { { 0, 2 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        graph = new ArrayList<>();
        indegree = new int[V];

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        ArrayList<Integer> ans = minHeightRoot_optimized(V, graph);
        System.out.println(ans);
    }
}
