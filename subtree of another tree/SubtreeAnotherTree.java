public class SubtreeAnotherTree {

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

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        boolean leftSubtree = isSubtree(root.left, subRoot);
        boolean rightSubtree = isSubtree(root.right, subRoot);

        return leftSubtree || rightSubtree;

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right = new Node(5);

        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        System.out.println(isSubtree(root, subRoot));
    }
}
