public class NewLinkedList {
    
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addAtLast(int data) {
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

        newNode.next = temp.next;
        temp.next = newNode;
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
        NewLinkedList ll = new NewLinkedList();

        ll.addAtFirst(2);
        ll.addAtFirst(1);
        ll.addAtLast(4);
        ll.addAtLast(5);
        ll.addAtMiddle(3, 2);

        ll.print();
    }
}
