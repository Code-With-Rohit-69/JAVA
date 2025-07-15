public class TrappingWaterProblem {

    public static int TrappingRainWater(int arr[]) {
        int maxWater = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int width = j - i;
                int height = Math.min(arr[i], arr[j]);

                int totalWater = width * height;

                maxWater = Math.max(maxWater, totalWater);
            }
        }

        return maxWater;
    }

    public static int OptimizedTrappingRainWater(int arr[]) {
        int maxWater = Integer.MIN_VALUE;

        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            int width = end - start;
            int height = Math.min(arr[start], arr[end]);

            int totalWater = width * height;

            maxWater = Math.max(maxWater, totalWater);

            if (arr[end] < arr[start]) {
                end--;
            } else {
                start++ ;
            }
        }

        return maxWater;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = OptimizedTrappingRainWater(arr);
        System.out.println(result);  
    }
}
