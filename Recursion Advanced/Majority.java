import java.util.Arrays;

public class Majority {

    public static int majority(int arr[]) {
        Arrays.sort(arr);
        int freq = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                freq += 1;
            } else {
                freq = 1;
            }

            if (freq > arr.length/2) {
                return arr[i];
            }
        }

        return -1;
    }

    // public static int majority(int arr[], int freq, int ans, int i) {

    //     if (i == arr.length) {
    //         return ans;
    //     }

    //     if (freq == 0) {
    //         ans = arr[i];
    //     }
    //     if (ans == arr[i]) {
    //         freq++;
    //     } else {
    //         freq--;
    //     }

    //     return majority(arr, freq, ans, i + 1);

    // }
    // public static int majority(int arr[]) {
    // int freq = 0;
    // int ans = 0;

    // for (int i = 0; i < arr.length; i++) {
    // if (freq == 0) {
    // ans = arr[i];
    // }
    // if (ans == arr[i]) {
    // freq++;
    // } else {
    // freq--;
    // }
    // }

    // return ans;

    // }
    public static void main(String[] args) {
        int arr[] = {3, 2, 3};
        // int freq = 0;
        // int ans = 0;
        // int i = 0;
        // int result = majority(arr, freq, ans, i);
        // System.out.println(result);
        // int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        int result = majority(arr);
        System.out.println(result);
    }
}
