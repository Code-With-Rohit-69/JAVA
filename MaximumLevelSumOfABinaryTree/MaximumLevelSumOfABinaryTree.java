import java.util.*;

public class MaximumLevelSumOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int bfs(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        int idx = 1;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int level = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                sum += curr.val;

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if(sum > maxSum) {
                maxSum = sum;
                level = idx;
            }

            idx++;
        }

        return level;
    }

    static List<Integer> list = new ArrayList<>();

    public static void dfs(TreeNode node, int level) {
        if(node == null) {
            return;
        }

        if(list.size() == level) {
            list.add(node.val);
        } else {
            list.set(level, list.get(level) + node.val);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = bfs(root);
        System.out.println("BFS Result: " + result);

        dfs(root, 0);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > maxSum) {
                maxSum = list.get(i);
                level = i + 1;
            }
        }

        System.out.println("DFS Result: " + level);

    }
}