import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxLengthChain {

    static class Pair {
        int num1;
        int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 },
        };

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.num2 - b.num2);

        // for (int i = 0; i < arr.length; i++) {
        // pq.add(new Pair(arr[i][0], arr[i][1]));
        // }

        int count = 0;
        int prev = Integer.MIN_VALUE;

        for (int[] curr : arr) {
            if (prev < curr[0]) {
                count++;
                prev = curr[1];
            }
        }

        // while (!pq.isEmpty()) {
        // Pair curr = pq.poll();

        // if (prev < curr.num1) {
        // count++;
        // prev = curr.num2;
        // }
        // }

        System.out.println(count);

    }
}
