public class Problem540 {

    public static int singleNonDuplicate(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0 && nums[mid] != nums[1]) {
                return nums[mid];
            }

            if (mid == nums.length-1 && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid-1]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        // int nums[] = { 3, 3, 7, 7, 10, 11, 11 };
        // int nums[] = { 1, 2, 2, 3, 3, 4, 4, 4 };
        int nums[] = { 1, 1, 2, 2, 3, 3, 4};
        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }
}