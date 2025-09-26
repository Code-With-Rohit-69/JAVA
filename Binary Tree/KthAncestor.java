public class KthAncestor {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int ans = -1;

    public static int kthAncestor(Node node, int n, int k) {
        if(node == null) {
            return -1;
        }

        if(node.data == n) {
            return 0;
        }

        int left = kthAncestor(node.left, n, k);
        int right = kthAncestor(node.right, n, k);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right);

        if (max + 1 == k) {
            ans = node.data;
        }

        return max + 1;

    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        kthAncestor(root, 5, 2);

        System.out.println(ans);
    }
}
