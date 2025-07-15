public class TwoSum {

    // public static int[] twoSum(int nums[], int target) {
    // int index = 0;

    // for (int i = 1; i < nums.length; i++) {
    // if (nums[index] + nums[i] == target) {
    // return new int[] {index, i};
    // }
    // index++;
    // }

    // return new int[] {-1, -1};
    // }

    public static int[] twoSum(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currSum = nums[left] + nums[right];

            if (currSum == target) {
                return new int[] { left, right };
            } else if (currSum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 8, 11, 12, 14 };
        // int nums[] = { 3, 2, 4 };
        int target = 15;

        int result[] = twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}