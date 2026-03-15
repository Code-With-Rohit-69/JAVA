public class Disjoint_set {

    static int n = 8;
    static int[] parent = new int[n];
    static int[] rank = new int[n];
    static int[] size = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            size[i] = i;
        }
    }

    public static int findParent(int n) {
        if (parent[n] == n)
            return n;

        return parent[n] = findParent(parent[n]); // path compression
    }

    public static void unionByRank(int a, int b) {
        int parentA = findParent(a), parentB = findParent(b);

        if (rank[parentA] == rank[parentB]) {
            parent[parentA] = parentB;
            rank[parentB]++;
        } else if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

    public static void unionBySize(int a, int b) {
        int parentA = findParent(a), parentB = findParent(b);

        if(parentA == parentB) return;

        if (size[parentA] == size[parentB]) {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        } else if (size[parentA] < size[parentB]) {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        } else {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
    }

    public static void main(String[] args) {
        init();
        unionBySize(1, 2);
        unionBySize(2, 3);
        unionBySize(4, 5);
        unionBySize(6, 7);
        unionBySize(5, 6);
        if (findParent(3) == findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        unionBySize(3, 7);
        if (findParent(3) == findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}