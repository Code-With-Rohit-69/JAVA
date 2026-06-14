public class RangeSum {

    static int n;
    static int block_size;
    static int[] block;

    public static void build(int[] nums) {
        for (int i = 0; i < n; i++) {
            int blockIndex = i / block_size;
            block[blockIndex] += nums[i];
        }
    }

    public static void update(int index, int val, int[] nums) {
        int blockIndex = index / block_size;
        block[blockIndex] = block[blockIndex] - nums[index] + val;
        nums[index] = val;
    }

    public static int query(int l, int r, int[] nums) {
        int sum = 0;

        int startBlock = l / block_size;
        int endBlock = r / block_size;

        // If both have same block index

        if (startBlock == endBlock) {
            for (int i = l; i <= r; i++) {
                sum += nums[i];
            }

            return sum;
        }

        // if they have differ block index
        // we first calculate the left partial block sum in O(sqrt(n))

        int endIndexOfStartBlock = ((startBlock + 1) * block_size) - 1;

        for (int i = l; i <= endIndexOfStartBlock; i++) {
            sum += nums[i];
        }

        // then we calculate the block sum which we preprocess it earlier in the time
        // complexity of O(1)

        for (int b = startBlock + 1; b < endBlock; b++) {
            sum += block[b];
        }

        // at last we calculate the sum of right partial remaining sum in O(sqrt(n))
        // time complexity

        int startIndexOfEndBlock = endBlock * block_size;

        for (int i = startIndexOfEndBlock; i <= r; i++) {
            sum += nums[i];
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        n = nums.length;
        block_size = (int) Math.ceil((double) Math.sqrt(n));
        block = new int[block_size];

        build(nums);

        /*
         * 
         * System.out.println("Printing Block Sum");
         * for (int x : block) {
         * System.out.print(x + " ");
         * }
         * 
         */

        int[][] queries = {
                { 2, 7 },
                { 1, 4 },
                { 0, 3 },
                { 8, 11 },
                { 4, 11 },
                { 5, 9 }
        };

        for (int[] q : queries) {
            System.out.println("For Query " + q[0] + " and " + q[1] + " is: " + query(q[0], q[1], nums));
        }

        return;
    }
}
