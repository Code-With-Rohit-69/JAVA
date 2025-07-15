import java.util.*;

class SubsetBacktrack {
    public static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Exclude current element
        generateSubsets(nums, index + 1, current, result);
        
        // Include current element
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, result);
        
        // Backtrack (undo choice)
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        
        System.out.println(result);
    }
}
