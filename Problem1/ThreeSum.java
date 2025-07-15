import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int newtarget = target - nums[i];

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int currSum = nums[left] + nums[right];
                if (currSum == newtarget) {
                    System.out.println("Triplets are: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    left++;
                    right--;
                } else if (currSum < newtarget) {
                    left++;
                } else {
                    right--;
                }
            }

        }
    }

    public static void main(String[] args) {
        // List <Integer> nums = new ArrayList<>();
        int nums[] = { 2, 4, 7, 9, 12, 14 };
        // nums.add(2);
        // nums.add(4);
        // nums.add(7);
        // nums.add(9);
        // nums.add(12);
        // nums.add(14);
        threeSum(nums);
    }
}
