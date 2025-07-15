import java.util.Deque;
import java.util.LinkedList;

// Deque stands for double ended queue we can add, remove, get the elements from both starting and ending point

public class DequeDS {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);

        System.out.println(deque);

        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque);

    }
}
