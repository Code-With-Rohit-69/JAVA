public class RangeSum {

    public static void main(String[] args) {
        int[] nums = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
        BIT bit = new BIT(nums);

        // Range sum [2, 5] (1-based index: elements 2, -1, 6, 5) -> sum = 12
        System.out.println("Sum of range [2, 5]: " + bit.rangeSum(2, 5));

        // Update index 3 by adding 5 (element at index 3 becomes -1 + 5 = 4)
        bit.add(3, 5);

        // Range sum [2, 5] after update -> sum = 17
        System.out.println("Sum of range [2, 5] after update: " + bit.rangeSum(2, 5));
    }
}


class BIT {
    int n;
    int[] tree;

    public BIT(int n) {
        this.n = n;
    }

    public BIT(int[] arr) {
        this.n = arr.length;
        this.tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tree[i + 1] = arr[i];
        }

        for (int i = 1; i <= n; i++) {
            int parent = i + (i & (-i));

            if (parent <= n) {
                tree[parent] += tree[i];
            }
        }
    }

    public void add(int index, int val) {
        while (index <= n) {
            tree[index] += val;

            index = index + (index & (-index));
        }
    }

    public int query(int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index = index - (index & (-index));
        }

        return sum;
    }

    public int rangeSum(int left, int right) {
        return query(right) - query(left - 1);
    }
}