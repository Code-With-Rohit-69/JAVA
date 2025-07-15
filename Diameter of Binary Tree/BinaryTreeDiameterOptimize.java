public class BinaryTreeDiameterOptimize {

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

    static class Info {
        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info findDiameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = findDiameter(root.left);
        Info rightInfo = findDiameter(root.right);

        int self = leftInfo.height + rightInfo.height + 1;

        int diameter = Math.max(self, Math.max(leftInfo.diameter, rightInfo.diameter));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int diam = findDiameter(root).diameter;

        System.err.println(diam);
    }
}
