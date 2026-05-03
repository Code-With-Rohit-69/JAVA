public class RangeSumQuery {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int i, int j, int index, int[] arr) {
        if (i == j) {
            tree[index] = arr[i];
            return arr[i];
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

        return tree[index];
    }

    public static int updateST(int i, int j, int index, int idx, int val) {
        if (i == j) {
            tree[index] = val;
            return val;
        }

        int mid = i + (j - i) / 2;

        if (mid >= idx) {
            updateST(0, mid, 2 * index + 1, idx, val);
        } else {
            updateST(mid + 1, j, 2 * index + 2, idx, val);
        }

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

        return tree[index];

    }

    public static int rangeSum(int i, int j, int l, int r, int index) {

        if (j < l || i > r)
            return 0;

        if (l <= i && j <= r)
            return tree[index];

        int mid = i + (j - i) / 2;

        return rangeSum(i, mid, l, r, 2 * index + 1) + rangeSum(mid + 1, j, l, r, 2 * index + 2);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 7, 2, 1, 2, 3 };
        int n = arr.length;

        init(n);
        buildST(0, n - 1, 0, arr);
        // updateST(0, n - 1, 0, 3, 10);

        int ans = rangeSum(0, n - 1, 1, 4, 0);
        System.out.println(ans);

    }
}
