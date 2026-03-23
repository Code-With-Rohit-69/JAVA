import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Number_of_BST_From_Array {

    public static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;

        int fact = 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;

    }

    public static int[] findCatalan(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = fact(2 * i) / (fact(i + 1) * fact(i));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3 };
        int[] sorted = arr.clone();
        int n = arr.length;

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }

        int[] catalan = findCatalan(n);

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = map.get(arr[i]);
            int left = index, right = n - index - 1;
            res.add(catalan[left] * catalan[right]);
        }

        System.out.println(res);

    }
}

// catalan's Formaulae = fact(2n) / fact(n+1) * fact(n)