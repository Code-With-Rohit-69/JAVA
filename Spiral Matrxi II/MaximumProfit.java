public class MaximumProfit {

    public static int maximumProfit(int arr[]) {
        int profit = 0;
        int buy = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currentProfit = arr[i] - buy;
            profit = Math.max(currentProfit, profit);

            if (buy > arr[i]) {
                buy = arr[i];
            }

        }

        return profit;

    }

    public static void main(String[] args) {
        // int arr[] = { 7, 6, 4, 3, 1 };
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maximumProfit(arr));

    }
}
