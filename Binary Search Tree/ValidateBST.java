public class ValidateBST {

    public static boolean dfs(Node node, int min, int max) {

        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        boolean left = dfs(node.left, min, node.data);
        boolean right = dfs(node.right, node.data, max);

        return left && right;

    }

    public static void main(String[] args) {
        // Node root = new Node(5);
        // root.left = new Node(2);
        // root.left.left = new Node(1);
        // root.left.right = new Node(3);
        // root.right = new Node(4);

        Node root = new Node(6);
        root.left = new Node(7);
        root.left.right = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        boolean result = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);

    }
}

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}