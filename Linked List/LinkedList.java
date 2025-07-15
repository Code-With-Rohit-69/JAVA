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

    public void addFirst(int data) {

        // (1) = Create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // (2) = point the newNode to the head
        newNode.next = head;
        
        // (3) = make the new node to Head
        head = newNode;

    }

    public void addLast(int data) {

        // create a new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // initalize the newNode to the next of tail
        tail.next = newNode;

        // make the newNode to tail
        tail = newNode;

    }

    public void printLinkedList() {
        Node temp = head;

        if (head == null) {
            System.out.println("Linked List is null");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLinkedList();
        
        ll.addFirst(2);
        ll.printLinkedList();

        ll.addFirst(1);
        ll.printLinkedList();

        ll.addLast(3);
        ll.printLinkedList();

        ll.addLast(4);

        ll.printLinkedList();
    }
}
