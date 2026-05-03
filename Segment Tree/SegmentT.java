public class SegmentT {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int i, int j, int index, int[] arr) {
        if (i == j) {
            tree[index] = arr[i];
            return tree[index];
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

        return tree[index];

    }

    public static int updateST(int i, int j, int index, int idx, int val, int[] arr) {

        if (i == j) {
            tree[index] = val;
            return val;
        }

        int mid = i + (j - i) / 2;

        if (mid >= idx) {
            updateST(i, mid, 2 * index + 1, idx, val, arr);
        } else {
            updateST(mid + 1, j, 2 * index + 2, idx, val, arr);
        }

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

        return tree[index];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;

        init(n);
        buildST(0, n - 1, 0, arr);

        System.out.println("Before Updating: ");

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();

        System.out.println("After Updating: ");

        updateST(0, n - 1, 0, 3, 10, arr);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();

    }
}
