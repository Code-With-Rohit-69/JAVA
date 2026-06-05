import java.util.HashSet;

public class Count_Special_Integers {

    public static int dfs(String s, int pos, HashSet<Integer> vis, int tight, int started) {
        if (pos == s.length()) {
            return started;
        }

        int ans = 0;
        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        for (int digit = 0; digit <= limit; digit++) {

            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newStarted = (started == 1 || digit != 0) ? 1 : 0;

            if (newStarted == 0) {
                ans += dfs(s, pos + 1, vis, newTight, 0);
            } else {
                if (vis.contains(digit))
                    continue;

                vis.add(digit);
                ans += dfs(s, pos + 1, vis, newTight, newStarted);
                vis.remove(digit);

            }

        }

        return ans;

    }

    public static void main(String[] args) throws Exception {
        int n = 2000000000;

        String s = String.valueOf(n);
        int len = s.length();

        int res = dfs(s, 0, new HashSet<>(), 1, 0);

        System.out.println(res);

    }
}
