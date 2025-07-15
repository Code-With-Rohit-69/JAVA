import java.util.*;

public class Permutations2 {

    public static List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        generatePermutation(nums, mainList, list);

        return mainList;
    }

    public static void generatePermutation(int nums[], List<List<Integer>> mainList, List<Integer> list) {

        if (nums.length == 0) {
            mainList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int currInteger = nums[i];

            // int newArr[] = 

            list.add(currInteger);
            generatePermutation(nums, mainList, list);
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        permute(nums);
    }
}
