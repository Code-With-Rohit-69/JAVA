public class ContainerWithMostWater {

    public static int problem(int[] height){
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;

                int currArea = w * h;
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int bigger = 0;
        // int index = -1;
        // int lastElement = height.length - 1;
        // for (int i = 0; i < height.length - 1; i++) {
        //     if (height[i] > bigger) {
        //         bigger = height[i];
        //         index = i;
        //     }

        // }
        // int difference = lastElement - index;
        // int result = difference * height[lastElement];

        // System.out.println(result);
        int result = problem(height);
        System.out.println(result);
    }
}
