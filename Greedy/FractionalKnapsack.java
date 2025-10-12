import java.util.PriorityQueue;

public class FractionalKnapsack {

    static class Pair {
        int weight;
        int value;
        double ratio;

        public Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public static void main(String[] args) {
        int[] weight = { 5, 10, 15 };
        int[] value = { 10, 40, 30 };
        int W = 20;

        double ans = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.ratio, a.ratio));

        for(int i = 0; i < weight.length; i++) {
            pq.add(new Pair(weight[i], value[i]));
        }

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (curr.weight <= W) {
                ans += curr.value;
                W -= curr.weight;
            } else {
                ans += curr.ratio * W;
                break;
            }

        }

        System.out.println(ans);

    }
}