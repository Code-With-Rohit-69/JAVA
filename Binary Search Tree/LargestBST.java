public class LargestBST {

    public static boolean validateBST(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data >= max || node.data <= min)
            return false;

        boolean left = validateBST(node.left, min, node.data);
        boolean right = validateBST(node.right, node.data, max);

        return left && right;
    }

    public static int calcSize(Node node) {
        if (node == null)
            return 0;

        int left = calcSize(node.left);
        int right = calcSize(node.right);

        return left + right + 1;
    }

    public static int largestBST(Node node) {
        if (node == null)
            return 0;

        boolean isValidate = validateBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (isValidate) {
            return calcSize(node);
        }

        return Math.max(largestBST(node.left), largestBST(node.right));
    }

    public static Info largBST(Node node) {
        if (node == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = largBST(node.left);
        Info right = largBST(node.right);

        if (left.max < node.data && right.min > node.data) {
            return new Info(Math.max(left.max, node.data), Math.min(right.min, node.data), left.size + right.size + 1);
        }

        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));

    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(7);
        root.left.right = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        // Node root = new Node(5);
        // root.left = new Node(2);
        // root.left.left = new Node(1);
        // root.left.right = new Node(3);
        // root.right = new Node(4);

        // int result = largestBST(root);

        // System.out.println(result);

        Info result = largBST(root);
        System.out.println(result.size);

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

class Info {
    int min;
    int max;
    int size;

    public Info(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}