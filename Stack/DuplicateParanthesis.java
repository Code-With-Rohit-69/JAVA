import java.util.Stack;

public class DuplicateParanthesis {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {

                int count = 0;

                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch); 
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "(a+b)";
        // String str = "((a+b) + (c+d))";
        // String str = "(((a+b) + (c+d)))";
        // String str = "((a))";

        boolean result = isDuplicate(str);

        System.out.println(result);
    }
}
