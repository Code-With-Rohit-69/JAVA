public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addAtFirst(int data) {

        // create a new node
        Node newNode = new Node(data);
        size++ ;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // intialize the next of newNode to head
        newNode.next = head;

        // initalize the newNode to head
        head = newNode;
    }

    public void addAtLast(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++ ;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // initialize the next of tail to newNode
        tail.next = newNode;

        // initialize the newNode to tail
        tail = newNode;
    }

    public void addAtMiddle(int data, int idx) {
        if (idx == 0) {
            addAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++ ;
        Node temp = head;

        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++ ;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void Findsize() {
        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        System.out.println("\nThe Size of Linked List is: " + length);
    }

    public void removeAtFirst() {
        Node temp = head;

        head = temp.next;
    }

    public void removeLast() {
        Node temp = head;

        while (temp != tail) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addAtFirst(2);
        ll.addAtFirst(1);
        ll.addAtLast(3);
        ll.addAtLast(4);
        ll.addAtMiddle(9, 2);
        ll.print();
        ll.Findsize();
        ll.removeAtFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        
    }
}