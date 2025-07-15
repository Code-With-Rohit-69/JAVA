import java.util.List;
import java.util.ArrayList;

// public class Subsets {

//     public static void subsets(String str, int idx, String ans) {

//         if (idx == str.length()) {
//             if (ans.length() == 0) {
//                 System.out.print("null");
//                 return;
//             }
//             System.out.print(ans + " ");
//             return;
//         }

//         char ch = str.charAt(idx);
//         // yes
//         subsets(str, idx+1, ans+ch);
//         // no
//         subsets(str, idx+1, ans);
//     }
//     public static void main(String[] args) {
//         String str = "abc";
//         subsets(str, 0, "");
//     }
// }

public class Subsets {

    public static List<List<Integer>> subsets(int arr[]) {
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int idx = 0;

        generateSubsets(arr, mainList, list, idx);

        return mainList;
    }

    public static void generateSubsets(int arr[], List<List<Integer>> mainList, List<Integer> list, int idx) {

        if (idx == arr.length) {
            mainList.add(new ArrayList<>(list));
            return;
        }

        // yes branch
        list.add(arr[idx]);
        generateSubsets(arr, mainList, list, idx + 1);

        // no branch
        list.remove(list.size() - 1);
        generateSubsets(arr, mainList, list, idx + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        List<List<Integer>> result = subsets(arr);
        for (List<Integer> list : result) {
            System.out.print(list + ", ");
        }
    }
}