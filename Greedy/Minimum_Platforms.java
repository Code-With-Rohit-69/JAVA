import java.util.Arrays;

public class Minimum_Platforms {

    public static void main(String[] args) {
        int arr[] = { 1000, 935, 1100 }, dep[] = { 1200, 1240, 1130 };
        // int arr[] = { 900, 1235, 1100 }, dep[] = { 1000, 1240, 1200 };
        // int arr[] = { 900, 940, 950, 1100, 1500, 1800 }, dep[] = { 910, 1200, 1120,
        // 1130, 1900, 2000 };

        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;

        int need = 0;
        int count = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                need++;
                i++;
            }
            else {
                need--;
                j++;
            }

            count = Math.max(count, need);
        }

        System.out.println(count);

    }
}

/*
 * 
 * 900 -> 910
 * 950 -> 1120
 * 1100 -> 1130
 * 940 -> 1200
 * 1500 -> 1900
 * 1800 -> 2000
 * 
 */