import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int n) {
            deque.addLast(n);
        }

        public int pop() {
            if(deque.isEmpty()) {
                return -1;
            }

            return deque.removeLast();
        }

        public int peek() {
            if(deque.isEmpty()) {
                return -1;
            }

            return deque.getLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

    }
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println(stack.peek());

    }
}