public class TrappingRainwater {

    public static int trap(int height[]) {
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

    public static void main(String[] args) {
        // int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        // int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int height[] = { 4, 2, 0, 3, 2, 5 };
        int result = trap(height);
        System.out.println(result);
    }
}