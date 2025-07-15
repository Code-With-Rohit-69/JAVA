public class SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0 && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            if (mid == nums.length-1 && nums[mid] != nums[nums.length-2]) {
                return nums[mid];
            }

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 3, 3, 7, 7, 10, 11, 11 };
        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }
}
