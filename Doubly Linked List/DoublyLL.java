public class DoublyLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addAtFirst(int data) {

        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        newNode.prev = null;
        head = newNode;

    }

    public static int removeAtFirst() {
        if (head == null) {
            return -1;
        }

        size--;

        if (head.next == null) {
            int data = head.data;
            head = tail = null;
            return data;
        }

        int data = head.data;
        head = head.next;
        head.prev = null;

        return data;
    }

    public static void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void print() {
        Node trav = head;

        while (trav != null) {
            System.out.print(trav.data + " <-> ");
            trav = trav.next;
        }

        System.out.print(trav);

        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLL LL = new DoublyLL();

        LL.addAtFirst(5);
        LL.addAtFirst(4);
        LL.addAtFirst(3);
        LL.addAtFirst(2);
        LL.addAtFirst(1);

        LL.print();
        LL.reverse();
        LL.print();

        System.out.println("Size: " + LL.size);

    }
}
