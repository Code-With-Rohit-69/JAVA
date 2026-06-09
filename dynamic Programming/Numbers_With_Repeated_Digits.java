import java.util.Arrays;

public class Numbers_With_Repeated_Digits {

    static int[][][][][] memo;

    /*
     * 
     * public static boolean checkDuplicates(int num) {
     * int[] freq = new int[10];
     * 
     * while (num > 0) {
     * int r = num % 10;
     * if (freq[r] == 1)
     * return true;
     * 
     * freq[r]++;
     * 
     * num /= 10;
     * }
     * 
     * return false;
     * }
     * 
     */

    public static int dfs(String s, int index, int mask, int tight, int leading, int repeated) {
        if (index == s.length()) {
            return repeated;
        }

        if (memo[index][mask][tight][leading][repeated] != -1)
            return memo[index][mask][tight][leading][repeated];

        int limit = tight == 1 ? s.charAt(index) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            int newTight = (tight == 1 && i == limit) ? 1 : 0;
            int newLeading = (leading == 0 && i == 0) ? 0 : 1;

            if(newLeading == 0) {
                ans += dfs(s, index + 1, mask, newTight, newLeading, repeated);
            } else {
                if ((mask & (1 << i)) != 0) {
                    ans += dfs(s, index + 1, mask, newTight, newLeading, 1);
                } else {
                    ans += dfs(s, index + 1, mask | (1 << i), newTight, newLeading, repeated);
                }
            }
        }

        return memo[index][mask][tight][leading][repeated] = ans;
    }

    public static int solve(int n) {
        String s = String.valueOf(n);
        int len = s.length();

        memo = new int[len][1024][2][2][2];

        for (int[][][][] arr : memo) {
            for (int[][][] ar : arr) {
                for (int[][] a : ar) {
                    for(int[] A : a) {
                        Arrays.fill(A, -1);
                    }
                }
            }
        }

        return dfs(s, 0, 0, 1, 0, 0); // string , current index, mask, tightness, leading, repeated

    }

    public static void main(String[] args) {
        // int n = 1000;
        int n = 1000000000;
        int res = solve(n);

        System.out.println(res);
    }
}