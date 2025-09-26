import java.util.Arrays;

public class SmallestString {

    public static String getSmallestString(int n, int k) {
        char[] ch = new char[n];
        Arrays.fill(ch, 'a');

        int idx = ch.length - 1;

        k -= n;

        while (k > 0) {
            if (k > 25) {
                ch[idx] = 'z';
                k -= 25;
            } else {
                ch[idx] += k;
                k = 0;
            }
            idx--;
        }

        return new String(ch);

    }

    public static void main(String[] args) {
        int n = 3, k = 73;

        String ans = getSmallestString(n, k);

        System.out.println(ans);

    }
}
