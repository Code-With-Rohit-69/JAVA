public class ConnectingGraph {

    static int[] parent;
    static int[] rank;

    public static int findParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = findParent(a), parentB = findParent(b);
        if (parentA == parentB)
            return;

        if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else if (rank[parentB] < rank[parentA]) {
            parent[parentB] = parentA;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }
    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int n = 5;

        int m = edges.length;
        if (m < n - 1) {
            System.out.println(-1);
            return;
        }

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i == parent[i])
                count++;
        }

        System.out.println(count - 1);
    }
}
