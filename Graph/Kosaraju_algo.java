package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_algo {
    // Kosaraju’s Algorithm to find Strongly Connected Components (SCCs) in a directed graph

    /*
     * -- Sort all the edges acc. to finishing time
     * -- reverse the graph
     * -- do a dfs
     */

    static Stack<Integer> stack;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void sort(int src) {
        visited[src] = true;

        for (int neigh : graph.get(src)) {
            if (!visited[neigh]) {
                sort(neigh);
            }
        }

        stack.push(src);
    }

    public static void dfs(int src) {
        visited[src] = true;

        for (int neigh : graph.get(src)) {
            if (!visited[neigh]) {
                dfs(neigh);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int edges[][] = { { 0, 2 }, { 0, 3 }, { 1, 0 }, { 2, 1 }, { 3, 4 } };

        graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        stack = new Stack<>();
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                sort(i);
            }
        }

        graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        visited = new boolean[V];

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                count++;
                dfs(curr);
            }
        }

        System.out.println(count);

    }
}