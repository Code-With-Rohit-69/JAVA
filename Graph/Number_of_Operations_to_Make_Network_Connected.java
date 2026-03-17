public class Number_of_Operations_to_Make_Network_Connected {

    static int[] parent;
    static int[] rank;

    public static int findParent(int x) {
        if(x == parent[x]) return x;

        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = findParent(a), parentB = findParent(b);

        if(parentA == parentB) return;

        if(rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else if(rank[parentB] < rank[parentA]) {
            parent[parentB] = parentA;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }

    public static void main(String[] args) {
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        int n = 6;

        int m = connections.length;

        if(m < n - 1) {
            System.out.println(-1);
            return;
        }

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(parent[i] == i) count++;
        }

        System.out.println(count - 1);
    }
}
