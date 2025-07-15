public class BinaryTreeDiameter {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSubtree = height(root.left);
        int rightSubtree = height(root.right);

        return Math.max(leftSubtree, rightSubtree) + 1;

    }

    public static int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int ld = diameter(root.left);
        int lh = height(root.left);
        int rd = diameter(root.right);
        int rh = height(root.right);

        int self = lh + rh + 1;

        return Math.max(self, Math.max(ld, rd));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int ans = diameter(root);

        System.out.println("Diameter: " + ans);

    }
}