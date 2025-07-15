public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    }

    public void addAtMiddle(int data, int index) {
        Node newNode = new Node(data);

        Node temp = head;
        int idx = 0;

        while (idx < index-1) {
            temp = temp.next;
            idx++ ;
        }

        temp.next = newNode;
        temp = newNode;
    }

    public int iteration(int target) {
        int index = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.data == target) {
                return index;
            }

            temp = temp.next;
            index++ ;
        }

        return -1;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addAtMiddle(9, 2);

        ll.iteration(0);

        ll.print();
    }
}