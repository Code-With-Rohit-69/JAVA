package AgainPractice;

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
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++ ;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++ ;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addAtMiddle(int data, int idx) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++ ;

        int i = 0;
        Node temp = head;

        while (i < idx-1) {
            temp = temp.next;
            i++ ;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void size() {
        int length = 1;
        Node temp = head;

        while (temp != tail) {
            temp = temp.next;
            length ++;
        }

        System.out.println("The Size of Linked List is: " + length);
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
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addAtMiddle(9, 2);
        ll.print();
        ll.size();
        System.out.println(ll.size);
    }
}
