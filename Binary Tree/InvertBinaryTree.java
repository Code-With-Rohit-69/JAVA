public class InvertBinaryTree {
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

    public static void dfs(Node left, Node right) {
        if(left == null && right == null) {
            return;
        }

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        dfs(root.left, root.right);
        

    }
}
