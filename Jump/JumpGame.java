public class JumpGame {

    public static boolean canJump(int nums[]) {
        int maxJump = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxJump) {
                return false;
            }

            maxJump = Math.max(maxJump, i + nums[i]);

            if (i == nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 0, 4 };
        // int nums[] = { 2, 3, 1, 1, 4 };
        boolean result = canJump(nums);
        System.out.println(result);
    }
}