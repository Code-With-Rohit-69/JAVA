public class LCA2 {

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

    public static Node helper(Node node, int n1, int n2) {
        if(node == null || node.data == n1 || node.data == n2) {
            return node;
        }

        Node left = helper(node.left, n1, n2);
        Node right = helper(node.right, n1, n2);

        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        if (left != null && right != null) {
            return node;
        }

        return null;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(helper(root, 4, 5).data);

    }
}
