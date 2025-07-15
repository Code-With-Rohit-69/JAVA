import java.util.Stack;

public class PushAtTheBottom {

    public static void pushAtTheBottom(Stack<Integer> stack, int data) {

        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int val = stack.pop();
        pushAtTheBottom(stack, data);

        stack.push(val);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtTheBottom(stack, 4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
