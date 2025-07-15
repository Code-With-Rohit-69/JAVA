import java.util.ArrayList;

public class WaterProblem2 {
    public static int mostTrappedWater(ArrayList<Integer> arr) {
        int maxWater = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int width = j - i;
                int height = Math.min(arr.get(i), arr.get(j));

                int currArea = width * height;
                maxWater = Math.max(maxWater, currArea);
            }
        }

        return maxWater;
    }

    public static int optimizedMostTrappedWater(ArrayList<Integer> arr) {
        int maxWater = Integer.MIN_VALUE;

        int left = 0;
        int right = arr.size()-1;

        while (left != right) {
            int height = Math.min(arr.get(left), arr.get(right));
            int width = right - left;

            int area = width * height;
            maxWater = Math.max(maxWater, area);

            if (left > right) {
                right-- ;
            } else {
                left++ ;
            }
        }

        return maxWater;
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

        int result = optimizedMostTrappedWater(height);
        System.out.println(result);
    }
}
