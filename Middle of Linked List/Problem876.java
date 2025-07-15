public class Problem876 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

    }

    public Node middleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

        // Node temp = head;
        // Node traverseNode = head;
        // int size = 0;
        // int currentIndex = 1;

        // while (temp != null) {
        // size++;
        // temp = temp.next;
        // }

        // int middle = (size / 2) + 1;

        // while (currentIndex != middle) {
        // traverseNode = traverseNode.next;
        // currentIndex++ ;
        // }

        // System.out.println(traverseNode.data);
    }

    // public void deleteNode(Node node) {
    //     Node temp = head;

    //     while (temp.data != node.data) {
    //         temp = temp.next;
    //     }

    //     int idx = findingIdx(temp.data);

    //     System.out.println("The next of the give node is: " + node.next);
    //     System.out.println("The index of " + node.data + " is: " + idx);

    //     // going to the particular index

    //     int i = 0;
    //     Node traversalNode = head;

    //     while (traversalNode != null) {
    //         if (i != idx-1) {
    //             traversalNode = traversalNode.next;
    //             i++;
    //         } else {
    //             break;
    //         }
    //     }

    //     traversalNode.next = node.next;

    // }

    // public int findingIdx(int data) {
    //     Node temp = head;
    //     int i = 0;

    //     while (temp != null) {
    //         if (temp.data == data) {
    //             return i;
    //         }
    //         temp = temp.next;
    //         i++;
    //     }

    //     return -1;

    // }

    public void deleteNode(Node node) {

        if (head == null) {
            return;
        }

        if (head == node) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp != null && temp.next !=  null) {
            if (temp.next == node) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

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
        Problem876 ll = new Problem876();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();

        Problem876.Node node = ll.head.next.next.next;
        ll.deleteNode(node);
        ll.print();
    }
}