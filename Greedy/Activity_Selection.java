import java.util.Arrays;

public class Activity_Selection {
    
    public static void main(String[] args) {
        // int[] start= {1, 3, 0, 5, 8, 5};
        // int[] finish = {2, 4, 6, 7, 9, 9};

        int[] start= {10, 12, 20};
        int[] finish = {20, 25, 30};

        // int[] start= {1, 3, 2, 5};
        // int[] finish = {2, 4, 3, 6};

        int n = start.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        int prevFinished = arr[0][1];

        int count = 1;

        for (int i = 1; i < n; i++) {
            // System.out.println(arr[i][0] + " " + arr[i][1]);

            if (arr[i][0] > prevFinished) {
                count++;
                prevFinished = arr[i][1];
            }
        }

        System.out.println(count);

    }
}