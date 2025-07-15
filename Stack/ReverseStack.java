import java.util.Stack;

public class ReverseStack {

    public static void reverseStk(Stack<Integer> stack) {

        if(stack.isEmpty()) {
            return;
        }

        int val = stack.pop();
        reverseStk(stack);

        System.out.print(val + " ");
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Before reversing: ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();

        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("After reversing: ");
        reverseStk(stack);

        // Stack<Integer> newStack = new Stack<>();

        // while (!stack.isEmpty()) {
        //     System.out.println(newStack.push(stack.pop()));
        // }

    


    }
}
