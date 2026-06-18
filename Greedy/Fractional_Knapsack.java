import java.util.PriorityQueue;

public class Fractional_Knapsack {

    public static void main(String[] args) {
        // int[] val = { 60, 100, 120 };
        // int[] wt = { 10, 20, 30 };

        int[] val = { 500 };
        int[] wt = { 30 };
        int W = 10;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.v / (b.w * 1.0), a.v / (a.w * 1.0));
        });

        int n = val.length;

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(val[i], wt[i]));
        }

        double ans = 0.0;

        while (!pq.isEmpty() && W > 0) {
            Pair curr = pq.remove();

            int value = curr.v;
            int weight = curr.w;

            if (weight <= W) {
                ans += value;
                W -= weight;
            } else {

                ans += ((W / (weight * 1.0)) * value);

                W = 0;
                break;
            }

        }

        System.out.println(ans);

    }
}

class Pair {
    int v, w;

    public Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}