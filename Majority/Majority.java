import java.util.Arrays;

public class Majority {

    // public static int majorityElement(int arr[]) {

    // int n = arr.length;
    // int frequency = 1;

    // for (int i = 0; i < arr.length; i++) {
    // for (int j = i+1; j < arr.length; j++) {
    // if (arr[i] == arr[j]) {
    // frequency++ ;
    // }
    // }
    // if (frequency > n/2) {
    // return arr[i];
    // }
    // }

    // return -1;

    // }

    // public static int majorityElement(int arr[]) {
    //     Arrays.sort(arr); 
    //     int n = arr.length;

    //     if (n == 1) {
    //         return arr[0];
    //     }

    //     int frequency = 1;

    //     for (int i = 1; i < arr.length; i++) {
    //         if (arr[i] == arr[i - 1]) {
    //             frequency++;
    //         } else {
    //             frequency = 1;
    //         }

    //         if (frequency > n / 2) {
    //             return arr[i];
    //         }
    //     }

    //     return -1;

    // }

    public static int majorityElement(int arr[]) {
        int frequency = 0;
        int ans = 0;
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        for (int i = 0; i < arr.length; i++) {
            if (frequency == 0) {
                ans = arr[i];
            }
            if (arr[i] == ans) {
                frequency++ ;
            } else {
                frequency--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
    }
}