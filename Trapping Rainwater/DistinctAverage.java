import java.util.Arrays;

public class DistinctAverage {

    public static int distinctAverages(int nums[]) {
        float Averages[] = new float[nums.length / 2];
        Arrays.sort(nums);
        int si = 0;
        int ei = nums.length - 1;
        int idx = 0;

        while (si < ei) {
            float average = ((float) nums[si] + (float) nums[ei]) / 2;
            Averages[idx] = average;
            idx++;
            si++;
            ei--;
        }

        int output = 0;

        for (int i = 0; i < Averages.length; i++) {
            float curr = Averages[i];
            while (i < Averages.length && curr == Averages[i]) {
                output++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 1, 4, 0, 3, 5 };
        System.out.println(distinctAverages(nums));
    }
}
