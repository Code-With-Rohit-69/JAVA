import java.io.*;

public class Main {
    
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildST(int i, int j, int index, int[] arr) {
        if(i == j) {
            tree[index] = arr[i];
            return;
        }

        int mid = i + (j - i) / 2;

        buildST(i, mid, 2 * index + 1, arr);
        buildST(mid + 1, j, 2 * index + 2, arr);

        tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
    }

    public static int findMin(int i, int j, int index, int l, int r) {

        if(i > r || j < l) return Integer.MAX_VALUE;

        if(i >= l && j <= r) return tree[index];

        int mid = i + (j - i) / 2;

        int left = findMin(i, mid, 2 * index + 1, l, r);
        int right = findMin(mid + 1, j, 2 * index + 2, l, r);

        return Math.min(left, right);

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int n = fr.nextInt();
        int q = fr.nextInt();
        init(n);

        int[] A = new int[n];

        for(int i = 0; i < n; i++) A[i] = fr.nextInt();

        buildST(0, n - 1, 0, A);

        while(q-- > 0) {
            int l = fr.nextInt() - 1;
            int r = fr.nextInt() - 1;

            int res = findMin(0, n - 1, 0, l, r);

            out.append(res + "\n");

        }

        System.out.println(out);

    }
}

class FastReader {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0)
                return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int num = 0;
        while (c > ' ') {
            num = num * 10 + (c - '0');
            c = read();
        }
        return num * sign;
    }

    long nextLong() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long num = 0;
        while (c > ' ') {
            num = num * 10 + (c - '0');
            c = read();
        }
        return num * sign;
    }

    String next() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return null;
        }
        StringBuilder sb = new StringBuilder();
        while (c > ' ') {
            sb.append((char) c);
            c = read();
        }
        return sb.toString();
    }

    double nextDouble() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        double num = 0;
        while (c > ' ' && c != '.') {
            num = num * 10 + (c - '0');
            c = read();
        }
        if (c == '.') {
            double div = 10;
            while ((c = read()) > ' ') {
                num += (c - '0') / div;
                div *= 10;
            }
        }
        return num * sign;
    }
}