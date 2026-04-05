import java.util.Arrays;

public class Buy_Stock_with_Transaction_Fee {

    public static int recur(int[] arr, int k, int index, int canBuy, int[][] dp) {

        if (index == arr.length) {
            return 0;
        }

        if(dp[index][canBuy] != -1) return dp[index][canBuy];

        if (canBuy == 1) {
            int buy = recur(arr, k, index + 1, 0, dp) - arr[index];
            int skipBuying = recur(arr, k, index + 1, canBuy, dp);
            return dp[index][canBuy] = Math.max(buy, skipBuying);
        } else {
            int sell = arr[index] - k + recur(arr, k, index + 1, 1, dp);
            int skipSelling = recur(arr, k, index + 1, canBuy, dp);

            return dp[index][canBuy] = Math.max(sell, skipSelling);
        }
    }

    public static int tabulation(int[] arr, int k) {
        int[][] dp = new int[arr.length + 1][2];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit;

                if (j == 0) {
                    profit = Math.max(dp[i + 1][0], dp[i+1][1] - arr[i]);
                } else {
                    profit = Math.max(dp[i + 1][0] + arr[i] - k, dp[i+1][1]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        int[] arr = { 6, 1, 7, 2, 8, 4 };
        int k = 2, n = arr.length;

        // int[][] dp = new int[n][2];

        // for(int[] a : dp) {
        //     Arrays.fill(a, -1);
        // }

        // int res = recur(arr, k, 0, 1, dp);

        int res = tabulation(arr, k);

        System.out.println(res);

    }
}