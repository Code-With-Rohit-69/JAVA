import java.util.*;

public class Graph {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge> graph[], boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");

                for(int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.offer(e.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean[] visited, int curr) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.des]) {
                dfs(graph, visited, e.des);
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex

        graph[0].add(new Edge(0, 1, 5));

        // 1 - vertex

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 - vertex

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - vertex

        graph[4].add(new Edge(4, 2, 2));


        // for(int i = 0; i < graph[2].size(); i++) {
        //    Edge e = graph[2].get(i);
        //    System.out.print(e.des + " ");
        // }

        // bfs(graph, new boolean[V]);
        dfs(graph, new boolean[V], 0);

    }
}
