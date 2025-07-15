public class FirstAndLastOccurence {

    public static int[] searchRange(int nums[], int target) {
        int ans[] = new int[2];

        ans[0] = firstOccurence(nums, target);
        ans[1] = lastOccurence(nums, target);

        return ans;
    }

    public static int firstOccurence(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = start - 1;
            }
        }

        return result;
    }

    public static int lastOccurence(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = start - 1;
            }
        }

        return result;
    }

    public static void print(int nums[]) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {};
        // int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 0;
        int result[] = searchRange(nums, target);
        print(result);
    }
}
