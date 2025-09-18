import java.util.Stack;

public class ReverseStack2 {

    public static void insertAtLast(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }

        int top = stack.pop();
        insertAtLast(stack, num);
        stack.push(top);

    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        insertAtLast(stack, top);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack);

        reverse(stack);

        System.out.println(stack);

    }
}