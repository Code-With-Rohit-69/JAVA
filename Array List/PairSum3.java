import java.util.ArrayList;

public class PairSum3 {

    public static void pairSum(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;

        while (start < end) {
            if (list.get(start) + list.get(end) == target) {
                System.out.println(list.get(start) + " and " + list.get(end) + " has sum of " + target);
                return;
            } else if (list.get(start) + list.get(end) > target) {
                end--;
            } else if (list.get(start) + list.get(end) < target){
                start++ ;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 50;

        pairSum(list, target);
    }
}