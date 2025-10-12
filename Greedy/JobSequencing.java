import java.util.Arrays;

public class JobSequencing {

    public static void main(String[] args) {
        int[][] jobs = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 },
        };

        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        int time = 0;

        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i][0] > time) {
                System.out.println(jobs[i][0] + " -> " + jobs[i][1]);
                time++;
            }
        }

    }
}
