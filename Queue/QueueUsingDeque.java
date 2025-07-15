import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int n) {
            deque.addLast(n);
        }

        public int remove() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.removeFirst();
        }

        public int peek() {
            if (deque.isEmpty()) {
                return -1;
            }

            return deque.getFirst();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

    }
    
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }

        System.out.println(queue.peek());

    }
}
