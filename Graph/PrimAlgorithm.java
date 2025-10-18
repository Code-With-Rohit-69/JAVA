import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 0, 30));

    }
    
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean[] visited = new boolean[V];

        createGraph(graph);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(0, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (visited[curr.vertex] == false) {
                visited[curr.vertex] = true;

                cost += curr.cost;

                for (Edge node : graph[curr.vertex]) {
                    int v = node.des;
                    int wt = node.wt;

                    pq.offer(new Pair(v, wt));
                }
            }
        }

        System.out.println("cost: " + cost);

    }
}


class Edge {
    int src;
    int des;
    int wt;

    public Edge(int src, int des, int wt) {
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}

class Pair {
    int vertex;
    int cost;

    public Pair(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}