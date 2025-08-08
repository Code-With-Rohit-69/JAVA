import java.util.*;

public class Permutation {

    public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] isUsed) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }

            isUsed[i] = true;
            list.add(nums[i]);
            backtrack(result, list, nums, isUsed);
            list.remove(list.size() - 1);
            isUsed[i] = false;

        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        boolean[] isUsed = new boolean[nums.length];

        backtrack(result, list, nums, isUsed);

        System.out.println(result);
    }
}