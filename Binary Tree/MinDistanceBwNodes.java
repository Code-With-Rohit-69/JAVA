public class MinDistanceBwNodes {

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

    public static Node lca(Node node, int n1, int n2) {
        if (node == null || node.data == n1 || node.data == n2) {
            return node;
        }

        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left != null && right != null) {
            return node;
        }

        return null;
    }

    public static int helper(Node node, int n) {
        if (node == null) {
            return -1;
        }

        if (node.data == n) {
            return 0;
        }

        int left = helper(node.left, n);
        int right = helper(node.right, n);

        if (left == -1 && right == -1) {
            return -1;
        } else if(left == -1) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;

        Node result = lca(root, n1, n2);
        int first = helper(result, n1);
        int second = helper(result, n2);

        System.out.println(first + second);

    }
}