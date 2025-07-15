import java.util.Scanner;

public class LinkedListProblem1 {

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
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int data, int index) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        int idx = 0;

        while (idx < index - 1) {
            temp = temp.next;
            idx++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int search(int key) {
        int index = 0;

        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public void removeFirst() {
        Node temp = head;
        head = temp.next;
        size--;
    }

    public void removeLast() {
        Node temp = head;

        for (int i = 0; i < size-2; i++) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        size--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListProblem1 ll = new LinkedListProblem1();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(3, 2);

        System.out.print("Enter the key which you want to find: ");
        int key = sc.nextInt();

        ll.print();

        // int index = ll.search(key);
        // System.out.println(key + " is present on index number " + index);

        // System.out.println("The size of Linked List is: " + ll.size);

        // System.out.println("After removing first node: ");
        // ll.removeFirst();

        // ll.print();

        // System.out.println("The size of Linked List is: " + ll.size);

        // System.out.println("After removing last node: ");
        // ll.removeLast();

        // ll.print();

        // System.out.println("The size of Linked List is: " + ll.size);

        sc.close();
    }
}
