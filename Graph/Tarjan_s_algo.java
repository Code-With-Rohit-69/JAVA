package Graph;

import java.util.ArrayList;

public class Tarjan_s_algo {
    static ArrayList<ArrayList<Integer>> graph;

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

    }
}
