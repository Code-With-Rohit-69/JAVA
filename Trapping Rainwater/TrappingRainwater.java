public class TrappingRainwater {

    public static int BruteForce(int height[]) {
        int trappedWater = 0;

        if (height.length < 3) {
            return 0;
        }

        for (int i = 1; i < height.length - 1; i++) {
            int leftMostWater = 0;
            int rightMostWater = 0;

            for (int leftIndex = 0; leftIndex <= i; leftIndex++) {
                leftMostWater = Math.max(leftMostWater, height[leftIndex]);
            }

            for (int rightIndex = height.length - 1; rightIndex >= i; rightIndex--) {
                rightMostWater = Math.max(rightMostWater, height[rightIndex]);
            }

            int waterLevel = Math.min(leftMostWater, rightMostWater);

            int area = waterLevel - height[i];

            if (area < 0) {
                area = 0;
            }

            trappedWater += area;

        }

        return trappedWater;
    }

    public static int optimal(int[] height) {
        int n = height.length;

        int[] left = new int[n];
        left[0] = height[0];
        int maxLeft = height[0];

        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            left[i] = maxLeft;
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        int maxRight = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
        }

        int sum = 0;

        for (int i = 1; i < n - 1; i++) {
            sum += (Math.min(left[i], right[i]) - height[i]);
        }

        return sum;
    }

    public static int optimized(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1, maxLeft = -1, maxRight = -1;
        int sum = 0;

        while (i < j) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[j]);

            if(maxLeft < maxRight) {
                sum += maxLeft - height[i];
                i++;
            } else {
                sum += maxRight - height[j];
                j--;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        // int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int height[] = { 4, 2, 0, 3, 2, 5 };
        int result = optimized(height);
        System.out.println(result);
    }
}