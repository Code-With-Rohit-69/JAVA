import java.util.ArrayList;

public class WaterProblem {

    public static int containerWithMostWater(ArrayList<Integer> height) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int width = j - i;
                int ht = Math.min(height.get(i), height.get(j));
                int area = width * ht;
                maxValue = Math.max(maxValue, area);
            }
        }

        return maxValue;
    }

    public static int optimizedContainerWithMostWater(ArrayList<Integer> height) {
        int maxValue = 0;

        int left = 0;
        int right = height.size()-1;

        while (left < right) {
            int ht = Math.min(height.get(left), height.get(right));
            int width = right - left;
            int currArea = width * ht;

            maxValue = Math.max(maxValue, currArea);

            if (left < right) {
                left++ ;
            } else {
                right-- ;
            }
        }

        return maxValue;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

    // int result = containerWithMostWater(height);
    int result = optimizedContainerWithMostWater(height);

    System.out.println(result);

    }
}
