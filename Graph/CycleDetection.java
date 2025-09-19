import java.util.*;

public class CycleDetection {
    
    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void create(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4

        graph[4].add(new Edge(4, 3));
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i] && dfs(graph, visited, i, -1)) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par) {
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.des]) {
                if (dfs(graph, visited, e.des, curr)) {
                    return true;
                }
            } else if(visited[e.des] && e.des != par) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);

        System.out.println(hasCycle(graph));

    }
}
