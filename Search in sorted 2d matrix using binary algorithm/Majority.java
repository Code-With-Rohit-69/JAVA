import java.util.Arrays;

public class Majority {

    public static int majority(int nums[]) {
        Arrays.sort(nums); // 1 1 1 2 2 2 2
        int n = nums.length;

        int frequency = 1;
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                frequency++;
            } else {
                frequency = 1;
            }

            if (frequency > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        int result = majority(nums);
        System.out.println(result);
    }
}
