import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

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

    public static boolean getPath(Node root, int n, List<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean leftPart = getPath(root.left, n, path);
        boolean rightPart = getPath(root.right, n, path);

        if(leftPart || rightPart) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;

    }

    public static Node helper(Node root, int n1, int n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0; 

        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);

        return lca;

    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(helper(root, 4, 7).data);

    }
}
