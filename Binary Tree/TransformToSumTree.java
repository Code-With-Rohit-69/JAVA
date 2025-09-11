public class TransformToSumTree {
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

    public static int dfs(Node node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int data = node.data;

        if(node.left != null) {
            node.data = left + node.left.data + right + node.right.data;
        } else {
            node.data = left + right;
        }


        return data;
    }

    public static void traverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        traverse(root.left);
        traverse(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int result = dfs(root);
        System.out.println(result);
        traverse(root);

    }
}
