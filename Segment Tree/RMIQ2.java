public class RMIQ2 {

    static int[] tree;

    public static void init(int n) {
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

        int left = tree[2 * index + 1];
        int right = tree[2 * index + 2];

        if(arr[left] < arr[right]) {
            tree[index] = right;
        } else {
            tree[index] = left;
        }
    }

    public static int query(int i, int j, int index, int max, int[] arr) {
        if(i == j) {
            if (arr[tree[index]] > max) {
                return tree[index];
            }

            return -1;
        }
        
        int mid = i + (j - i) / 2;

        int result = Integer.MAX_VALUE;
        
        if(arr[tree[index]] > max) {
            result = tree[index];
            int res = query(i, mid, 2 * index + 1, max, arr);
            result = Math.min(result, res);
        } else {
            int res = query(mid + 1, j, 2 * index + 2, max, arr);
            result = Math.min(result, res);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 6, 4, 8, 5, 2, 7 };
        int[][] queries = { { 0, 1 }, { 0, 3 }, { 2, 4 }, { 3, 4 }, { 2, 2 } };
        int n = arr.length;

        init(n);
        buildST(0, n - 1, 0, arr);

        for(int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int max = Math.max(arr[l], arr[r]);

            int index = query(r + 1, n - 1, 0, max, arr);
            System.out.println(arr[index]);
        }

    }
}