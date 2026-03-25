public class Construct_Product_Matrix {
    
    final static int MOD = 12345;

    public static void print(int[][] arr) {
        for (int[] is : arr) {
            for (int num : is) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2}, {3, 4}
        };

        int m = grid.length, n = grid[0].length;

        int totalElem = m * n;

        long[] prefix = new long[totalElem];
        long[] suffix = new long[totalElem];

        prefix[0] = grid[0][0] % MOD;
        suffix[totalElem - 1] = grid[m - 1][n - 1] % MOD;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int index = i * n + j;
                if (index == 0) {
                    continue;
                }
                prefix[index] = (prefix[index - 1] * grid[i][j]) % MOD;
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int index = i * n + j;
                if (index == totalElem - 1) {
                    continue;
                }
                suffix[index] = (suffix[index + 1] * grid[i][j]) % MOD;
            }
        }

        int[][] output = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                long pre = index == 0 ? 1 : prefix[index - 1];
                long suff = index == totalElem - 1 ? 1 : suffix[index + 1];
                output[i][j] = (int) ((pre * suff) % MOD);
            }
        }

        print(output);

    }
}
