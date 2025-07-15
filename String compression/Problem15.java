import java.util.Arrays;

public class Problem15 {

    public static void threeSum(int nums[]) {
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int firstNumber = i;
            int result = 0 - nums[firstNumber];

            int secondNumber = firstNumber+1;
            int thirdNumber = n-1;

            while (secondNumber < thirdNumber) {
                if ((nums[secondNumber] + nums[thirdNumber]) == result) {
                    System.out.println(nums[firstNumber] + " " + nums[secondNumber] + " " + nums[thirdNumber]);
                    break;
                } else if (nums[secondNumber] + nums[thirdNumber] > result) {
                    thirdNumber-- ;
                } else {
                    secondNumber++ ;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // int nums[] = {0, 1};
        int nums[] = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
