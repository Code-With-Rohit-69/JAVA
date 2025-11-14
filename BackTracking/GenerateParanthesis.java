import java.util.*;

public class GenerateParanthesis {

    public static void helper(int n, String curr, int openBracket, int closeBracket, List<String> ans) {
        System.out.println("open: " + openBracket + ", close: " + closeBracket + ", curr: " + curr);

        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // Add '(' if we still have open brackets left
        if (openBracket < n) {
            helper(n, curr + "(", openBracket + 1, closeBracket, ans);
        }

        // Add ')' only if there are unmatched '('
        if (closeBracket < openBracket) {
            helper(n, curr + ")", openBracket, closeBracket + 1, ans);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();

        String curr = "(";
        int openBracket = 1;
        int closeBracket = 0;

        helper(n, curr, openBracket, closeBracket, ans);

        System.out.println(ans);
    }
}
