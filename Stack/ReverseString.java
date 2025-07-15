import java.util.Stack;

public class ReverseString {
    
    public static void main(String[] args) {
        String str = "rohit singh";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
