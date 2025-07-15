public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int nodes;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        nodes++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        nodes++ ;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    }

    public void addMiddle(int data, int index) {
        Node newNode = new Node(data);
        nodes++ ;
        Node temp = head;

        int idx = 0;

        while (idx < index-1) {
            temp = temp.next;
            idx++ ;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        // Node temp = head;

        // head = temp.next;

        System.out.println("After removing first node: ");
        int temp = head.data;

        head = head.next;

        return temp;

    }

    public int removeLast() {
        if (nodes == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if (nodes == 1) {
            head = tail = null;
            nodes = 0;
            return Integer.MIN_VALUE;
        }
        System.out.println("After removing last node: ");

        Node prev = head;

        for (int i = 0; i < nodes-2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        nodes-- ;
        return tail.data;
    }

    public int numberOfNodes() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++ ;
            temp = temp.next;
        }

        return count;
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

    public void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

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
        ll.addMiddle(9, 2);

        ll.print();
        ll.reverseLinkedList();
        ll.print();

        // System.out.println(ll.iteration(9));

    }
}