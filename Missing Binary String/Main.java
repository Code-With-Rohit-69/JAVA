import java.util.*;

public class Main {

    static HashSet<String> set;

    public static String recur(int idx, int n, StringBuilder sb) {
        if (sb.length() == n) {
            if (!set.contains(sb.toString())) {
                return sb.toString();
            }
            return "";
        }

        for (int i = 0; i <= 1; i++) {
            sb.append(i);
            String res = recur(idx + 1, n, sb);

            if (res.length() == n) {
                return res;
            }

            sb.deleteCharAt(sb.length() - 1);
        }

        return "";
    }

    public static void main(String[] args) {
        String[] strings = { "000", "001", "010", "100", "011", "101", "110" };
        set = new HashSet<>();

        for (String s : strings)
            set.add(s);

        String missString = recur(0, strings[0].length(), new StringBuilder());

        System.out.println(missString);
    }
}
