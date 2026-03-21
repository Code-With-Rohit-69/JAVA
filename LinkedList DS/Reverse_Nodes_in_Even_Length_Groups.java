public class Reverse_Nodes_in_Even_Length_Groups {

    public static Node reverseLinkedList(Node head) {
        Node curr = head, prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node reverseEvenLengthGroups(Node head, int size) {
        if (head == null)
            return null;

        Node temp = head;
        Node prev = null;
        int count = 0;

        while (count < size) {
            prev = temp;
            temp = temp.next;
            count++;
        }

        prev.next = null;

        Node returnedHead = reverseEvenLengthGroups(temp, size + 1);

        if (count % 2 == 0) {
            Node reverseNode = reverseLinkedList(head);
            head.next = temp;
            return reverseNode;
        }

        prev.next = returnedHead;
        return head;

    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next = new Node(4);
        System.out.print("Before reversing: ");
        print(head);
        Node resultNode = reverseEvenLengthGroups(head, 1);
        System.out.print("After reversing: ");
        print(resultNode);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}