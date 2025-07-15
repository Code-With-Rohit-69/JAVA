// import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // USED TO STORE THE VALUE IN ASCENDING ORDER
        pq.add(8);
        pq.add(2);
        pq.add(5);
        pq.add(1);
        pq.add(9);

        // System.out.println(pq);

        while(!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}