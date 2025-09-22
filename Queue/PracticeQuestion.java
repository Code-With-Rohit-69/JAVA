import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PracticeQuestion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int n = arr.length;
        int k = 3;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i <= n-k; i++) {
            int max = Math.max(arr[i], Math.max(arr[i+1], arr[i+2]));
            queue.add(max);
        }

        System.out.println(queue);

    }
}