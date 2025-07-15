import java.util.Arrays;

public class Duplicate {

    // public static boolean containsDuplicate(int nums[]) {
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[i] == nums[j]) {
    // return true;
    // }
    // }
    // }

    // return false;
    // }

    public static boolean containsDuplicate(int nums[]) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 14, 18, 22, 22 };
        // int nums[] = { 1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
