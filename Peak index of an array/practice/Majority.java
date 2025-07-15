package practice;

import java.util.Arrays;

public class Majority {

    public static int majority(int arr[]) {

        Arrays.sort(arr);

        int frequency = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                frequency++;
            } else {
                frequency = 1;
            }

            if (frequency > arr.length / 2) {
                return arr[i];
            }
        }

        return -1;
    }

    public static int optimizeMajority(int arr[]) {
        int frequency = 0;
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (frequency == 0) {
                ans = arr[i];
            }
            if (ans == arr[i]) {
                frequency++;
            } else {
                frequency--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        int result = optimizeMajority(arr);
        // int result = majority(arr);
        System.out.println(result);
    }
}
