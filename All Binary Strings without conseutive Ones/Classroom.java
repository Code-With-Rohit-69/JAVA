import java.util.ArrayList;
import java.util.List;

class Classroom {

    public static void backtrack(int n, List<String> result, StringBuilder curr) {
        if (curr.length() == n) {
            result.add(curr.toString());
            return;
        }

        curr.append(0);
        backtrack(n, result, curr);
        curr.deleteCharAt(curr.length() - 1);

        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            curr.append(1);
            backtrack(n, result, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();

        backtrack(n, result, new StringBuilder());
        System.out.println(result);
    }
}