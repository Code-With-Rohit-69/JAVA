import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    
    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // 4

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph, int[] color) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    
                    for(int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(color[e.des] == -1) {
                            int next = color[curr] == 0 ? 1 : 0;
                            color[e.des] = next;
                            q.add(e.des);
                        } else if (color[e.des] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;

    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        int[] color = new int[V];

        Arrays.fill(color, -1);

        boolean res = isBipartite(graph, color);
        System.out.println(res);

    }
}
