import java.util.Arrays;

public class TargetSumSubsets {

    static int count = 0;

    public static int helper(int[] nums, int target, int[][] dp, int currSum, int idx) {

        if (currSum > target)
            return 0;

        if (idx == nums.length) {
            return target == currSum ? 1 : 0;
        }

        if (dp[idx][currSum] != -1) {
            return dp[idx][currSum];
        }

        int take = helper(nums, target, dp, currSum + nums[idx], idx + 1);
        int notTake = helper(nums, target, dp, currSum, idx + 1);

        dp[idx][currSum] = take + notTake;

        return dp[idx][currSum];

    }

    public static void main(String[] args) {

        int[] nums = { 4, 2, 7, 1, 3 };
        int target = 10;

        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int result = helper(nums, target, dp, 0, 0);

        for (int[] is : dp) {
            for (int d : is) {
                System.out.print(d + " ");
            }
            System.out.println();
        }

        System.out.println(result);

    }
}