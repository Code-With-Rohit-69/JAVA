public class Questions {
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

    public static boolean isUnivalued(Node node, int x) {
        if(node == null) {
            return true;
        }

        if(node.data != x) {
            return false;
        }

        return isUnivalued(node.left, x) && isUnivalued(node.right, x);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(2);
        root.right = new Node(2);

        boolean result = isUnivalued(root, root.data);

        System.out.println(result);

    }
}
