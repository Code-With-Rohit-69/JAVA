public class Array {

    public static int trappedRainwater(int height[]) {
        // leftMax
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // rightMax

        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];

        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    public static int BuyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxPrice = Math.max(maxPrice, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxPrice;
    }

    public static void main(String[] args) {
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(BuyAndSellStocks(prices));

    }
}