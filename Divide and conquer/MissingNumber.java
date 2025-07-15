public class MissingNumber {

    public static int missingNumber(int nums[]) {
        int n = nums.length;
        int Nsum = 0;
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            Nsum += i;
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return Nsum - sum;
    }

    public static void main(String[] args) {
        int nums[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums));
    }
}
