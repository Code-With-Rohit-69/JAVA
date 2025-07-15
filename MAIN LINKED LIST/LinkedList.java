public class LinkedList {

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
    public static int size;

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
            i++;
        }

        return -1;

    }

    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addAtLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public void addAtMiddle(int data, int index) {
        if (index > size || index < 0) {
            return;
        }

        if (index == size) {
            addAtLast(data);
            return;
        }

        if (index == 0) {
            addAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void removeFromFirst() {
        size--;
        head = head.next;
    }

    public void removeFromLast() {
        Node temp = head;
        int i = 0;

        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void removeAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            removeFromFirst();
            return;
        }

        Node temp = head;
        size--;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

    }

    public int iteration(int target) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public void removeNthFromEnd(int n) {
        int size = 0;
        Node temp = head;

        while (temp != null) {
            size += 1;
            temp = temp.next;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int traversingIndex = size - n + 1;

        Node prev = head;
        int idx = 1;

        while (prev != null) {
            if (idx == traversingIndex - 1) {
                break;
            }
            idx++;
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }

    public boolean checkPallindromeUsingArray() {
        int size = 0;
        Node temp = head;

        while (temp != null) {
            size += 1;
            temp = temp.next;
        }

        int arr[] = new int[size];
        int idx = 0;
        Node traverse = head;

        while (traverse != null) {
            arr[idx] = traverse.data;
            idx++;
            traverse = traverse.next;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkPallindrome() {

        // EDGE CASES
        if (head == null || head.next == null) {
            return true;
        }

        // STEP 1 - FIND MID
        Node slow = head; // its our mid node
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2 - REVERSE SECOND HALF

        Node prev = null;
        Node currNode = slow;
        Node next;

        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        Node right = prev;

        // STEP 3 - CHECK LEFT HALF DATA AND RIGHT HALF DATA

        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

    public static boolean isCycling() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }

        return false;

    }

    public void detectCycle() {
        Node slow = head;
        Node fast = head;

        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        Node prevNode = null;

        if (isCycle) {
            slow = head;
            
            while (slow != fast) {
                prevNode = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prevNode.next = null;
        }
    }

    public void search(int key, int i, Node head) {

    }

    public void reverse() {
        Node curr = head;
        Node previous = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        head = previous;

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
        ll.addAtMiddle(9, 4);

        ll.print();

        // boolean isPallindrome = ll.checkPallindrome();
        // System.out.println(isPallindrome);

    }
}
// ll.addAtFirst(5);
// ll.addAtFirst(4);
// ll.addAtFirst(3);
// ll.addAtFirst(2);
// ll.addAtFirst(1);

// ll.addAtFirst(1);
// ll.addAtFirst(1);
// ll.addAtFirst(1);
// ll.addAtFirst(1);
// ll.addAtFirst(1);

// head = new Node(1);
// head.next = new Node(2);
// head.next.next = new Node(3);
// head.next.next.next = new Node(4);
// head.next.next.next.next = head.next;
// new LinkedList().print();

// System.out.println(isCycling());