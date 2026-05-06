public class RMQ {
    
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildST(int i, int j, int index, int[] arr) {
        if(i == j) {
            tree[index] = arr[i];
            return;
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
    }

    public static int findMin(int i, int j, int index, int l, int r) {

        if(i > r || j < l) return Integer.MAX_VALUE;

        if(i >= l && j <= r) return tree[index];

        int mid = i + (j - i) / 2;

        int left = findMin(i, mid, 2 * index + 1, l, r);
        int right = findMin(mid + 1, j, 2 * index + 2, l, r);

        return Math.min(left, right);

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int n = arr.length;
        init(n);

        buildST(0, n - 1, 0, arr);
        int min = findMin(0, n - 1, 0, 3, n - 1);

        System.out.println(min);

    }
}
