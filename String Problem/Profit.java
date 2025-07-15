public class Profit {

    public static int maxProfit(int prices[]) {
        // int midIndex = -1;

        // int larger = Integer.MIN_VALUE;
        // int smaller = Integer.MAX_VALUE;

        // int profit = 0;

        // for (int i = 0; i < prices.length; i++) {
        //     if (prices[i] < smaller) {
        //         smaller = prices[i];
        //         midIndex = i;
        //     }
        // }

        // for (int i = midIndex + 1; i < prices.length; i++) {
        //     if (prices[i] > larger) {
        //         larger = prices[i];
        //     }
        // }

        // profit = larger - smaller;

        // return profit;

        int smaller = Integer.MAX_VALUE;
        int minIndex = -1;
        int larger = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < smaller) {
                smaller = prices[i];
                minIndex = i;
            }

        }
        for (int j = minIndex + 1; j < prices.length; j++) {
            if (prices[j] > larger) {
                larger = prices[j];
            }
        }

        int profit = larger - smaller;
        // System.out.println("Maximum Profit = " + ());
        return profit;

    }

    public static void main(String[] args) {
        int arr[] = {7,6,4,3,1};
        // int arr[] = { 2, 1, 4 };
        System.out.println(maxProfit(arr));
    }
}
