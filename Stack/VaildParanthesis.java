import java.util.Stack;

public class VaildParanthesis {

    public static boolean vaildParanthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                if ((curr == ')' && stack.peek() == '(') || (curr == '}' && stack.peek() == '{') || (curr == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String str = ")()";

        boolean ans = vaildParanthesis(str);
        System.out.println(ans);
        

    }
}
