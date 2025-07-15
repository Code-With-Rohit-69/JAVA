import java.util.ArrayList;

public class StackDS {

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // IS EMPTY

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // PUSH

        public void push(int data) {
            list.add(data);
        }

        // POP

        public int pop() {
            int data = list.get(list.size() - 1);

            list.remove(list.size() - 1);

            return data;
        }

        // PEEK

        public int peek() {
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}