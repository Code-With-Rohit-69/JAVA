import java.util.List;
import java.util.ArrayList;

public class Subsets3 {

    public static List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int idx = 0;
        generateSets(nums, mainList, list, idx);

        return mainList;
    }

    public static void generateSets(int nums[], List<List<Integer>> mainList, List<Integer> list, int idx) {

        if (idx == nums.length) {
            mainList.add(new ArrayList<>(list));
            return;
        }

        // yes
        list.add(nums[idx]);
        generateSets(nums, mainList, list, idx + 1);

        // no
        list.remove(list.size() - 1);
        generateSets(nums, mainList, list, idx + 1);

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        List<List<Integer>> mainlist = subsets(nums);
        // for (List<Integer> subset : mainlist) {
        //     System.out.print(subset);
        // }

        System.out.println(mainlist);
    }
}
