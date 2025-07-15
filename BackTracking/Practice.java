import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static void subsets(int arr[], List<List<Integer>> mainList) {
        int idx = 0;
        List<Integer> list = new ArrayList<>();

        allSubsets(arr, mainList, list, idx);
    }

    public static void allSubsets(int arr[], List<List<Integer>> mainList, List<Integer> list, int idx) {
        if(idx == arr.length) {
            mainList.add(new ArrayList<>(list));
            return;
        }

        // yes

        list.add(arr[idx]);
        allSubsets(arr, mainList, list, idx+1);

        // no

        list.remove(list.size() - 1);
        allSubsets(arr, mainList, list, idx + 1);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();

        subsets(nums, result);

        System.out.println(result);
    }
}