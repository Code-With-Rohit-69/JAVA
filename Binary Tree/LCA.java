import java.util.*;

public class LCA {

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

    public static boolean findPath(Node node, ArrayList<Node> path, int n) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.data == n) {
            return true;
        }

        boolean leftPart = findPath(node.left, path, n);
        boolean rightPart = findPath(node.right, path, n);

        if (leftPart || rightPart) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public static Node helper(Node node, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        findPath(node, path1, n1);
        findPath(node, path2, n2);

        int i = 0;

        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lcaNode = path1.get(i - 1);

        return lcaNode;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node result = helper(root, 4, 5);
        System.out.println(result.data);
    }
}
