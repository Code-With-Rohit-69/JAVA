public class LazyPropagation {

    static int[] tree;
    static int[] lazy;

    public static void init(int n) {
        tree = new int[4 * n];
        lazy = new int[4 * n];
    }

    public static void buildST(int i, int j, int index, int[] arr) {
        if (i == j) {
            tree[index] = arr[i];
            return;
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public static void updateST(int i, int j, int index, int l, int r, int val) {

        if (lazy[index] != 0) {
            tree[index] = (j - i + 1) * lazy[index];

            if (i != j) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (i > r || j < l)
            return;

        if (i >= l && j <= r) {
            tree[index] += (j - i + 1) * val;

            if (i != j) {
                lazy[2 * index + 1] += val;
                lazy[2 * index + 2] += val;
            }

            return;
        }

        int mid = i + (j - i) / 2;

        updateST(i, mid - 1, 2 * index + 1, l, r, val);
        updateST(i, mid - 1, 2 * index + 2, l, r, val);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        int n = arr.length;
        init(n);

        buildST(0, n - 1, 0, arr);
        updateST(0, n - 1, 0, 2, 5, 9);

    }
}
