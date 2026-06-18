import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Job_Sequencing_Problem {

    public List<Integer> jobSequencing(int[] deadline, int[] profit) {
        int count = 0;
        int totalProfit = 0;

        int n = deadline.length;
        int max = Arrays.stream(deadline).max().getAsInt();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.p, a.p);
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(deadline[i], profit[i]));
        }

        boolean[] vis = new boolean[max + 1];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            int d = curr.d, p = curr.p;

            for (int i = d; i > 0; i--) {
                if (vis[i]) {
                    continue;
                }

                count++;
                totalProfit += p;
                vis[i] = true;
                break;

            }
        }


        return Arrays.asList(count, totalProfit);
    }

    public void main(String[] args) {
        // int[] deadline = { 4, 1, 1, 1 };
        // int[] profit = { 20, 10, 40, 30 };

        // int[] deadline = { 2, 1, 2, 1, 1 };
        // int[] profit = { 100, 19, 27, 25, 15 };

        int[] deadline = {3, 1, 2, 2};
        int[] profit = {50, 10, 20, 30};

        List<Integer> ans = jobSequencing(deadline, profit);

        System.out.println(ans);

    }
}

class Pair {
    int d, p;

    public Pair(int d, int p) {
        this.d = d;
        this.p = p;
    }
}