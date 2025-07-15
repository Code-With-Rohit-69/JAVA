import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UnionIntersection {

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int num : arr1) {
            if(set.contains(num)) {
                intersection.add(num);
            } else {
                set.add(num);
            }
        }

        for(int num : arr2) {
            if(set.contains(num)) {
                intersection.add(num);
            } else {
                set.add(num);
            }
        }

        System.out.println(set);
        System.out.println(intersection);

    }
}