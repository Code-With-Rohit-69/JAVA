public class DisjointUnion {
    static int n = 7;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static int findLeader(int x) {
        if(x == parent[x]) {
            return x;
        }

        return findLeader(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = findLeader(a);
        int parentB = findLeader(b);

        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (parentA < parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

    public static void main(String[] args) {
        init();

        System.out.println(findLeader(3));
        union(1, 3);
        System.out.println(findLeader(3));
        union(3, 4);
        union(4, 5);
        union(5, 6);
        System.out.println(findLeader(6));

    }
}
