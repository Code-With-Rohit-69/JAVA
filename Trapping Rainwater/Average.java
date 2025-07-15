public class Average {
    public static int averageValue(int nums[]) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] % 3 == 0) {
                sum += nums[i];
                count += 1;
            }
        }

        int average = sum / count;

        return average;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 6, 10, 12, 15 };
        int result = averageValue(nums);
        System.out.println(result);
        System.out.println(0/0);
    }
}
