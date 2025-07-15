import java.util.ArrayList;
import java.util.Collections;

public class Array {

    public static void printReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static int printMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static void swapByIndex(ArrayList<Integer> list, int idx1, int idx2) {
        int elem1 = list.get(idx1);
        int elem2 = list.get(idx2);

        list.set(idx1, elem2);
        list.set(idx2, elem1);

        System.out.print(list + " ");
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }

        // list1.add(1);
        // list1.add(2);
        // list1.add(3);

        // mainList.add(list1);
        // list2.add(4);
        // list2.add(5);
        // list2.add(6);

        // mainList.add(list2);

        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);

        // for (int j = 0; j < currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");
        // }
        // System.out.println();
        // }

        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);

        // System.out.println(list);

        // System.out.print("After Aescending Sorting: ");
        // Collections.sort(list);
        // System.out.println(list);

        // System.out.print("After Descending Sorting: ");
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);
        // swapByIndex(list, 1, 2);

        // System.out.println(printMax(list));

        // System.out.println(list.size());

        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i) + " ");
        // }

        // get operation

        // int elem = list.get(3);
        // System.out.println(elem);

        // remove operation

        // list.remove(3);
        // System.out.println(list);

        // set operation

        // list.set(2, 10);
        // System.out.println(list);

        // contains operation

        // System.out.println(list.contains(40));
    }
}