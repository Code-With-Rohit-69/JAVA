public class RangeMaximumIndexQuery {

    static int n;
    static int[] tree;

    public static void init() {
        tree = new int[4 * n];
    }

    public static void buildST(int i, int j, int index, int[] arr) {
        if(i == j) {
            tree[index] = i;
            return;
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        if(arr[tree[2 * index + 1]] < arr[tree[2 * index + 2]]) {
            tree[index] = tree[2 * index + 2];
        } else {
            tree[index] = tree[2 * index + 1];
        }
    }

    public static int findMin(int i, int j, int index, int l, int r, int[] arr) {
        if(i > r || j < l) return -1;

        if (i >= l && j <= r) {
            return tree[index];
        }

        int mid = i + (j - i) / 2;

        int left = findMin(i, mid, 2 * index + 1, l, r, arr);
        int right = findMin(mid + 1, j, 2 * index + 2, l, r, arr);

        if(left == -1) {
            return right;
        }

        if(right == -1) return left;

        if(arr[left] < arr[right]) {
            return right;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        n = arr.length; 

        init();

        buildST(0, n - 1, 0, arr);
        int res = findMin(0, n - 1, 0, 2, 6, arr);

        System.out.println(res);

    }
}
