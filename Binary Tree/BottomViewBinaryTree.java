import java.util.*;

public class BottomViewBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void helper(Node node, TreeMap<Integer, Integer> map, int mark) {
        if (node == null) {
            return;
        }

        map.put(mark, node.data);

        helper(node.left, map, mark - 1);
        helper(node.right, map, mark + 1);

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(70);
        root.right.right = new Node(80);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        helper(root, map, 0);

        for(int num : map.keySet()) {
            System.out.print(map.get(num) + " ");
        }

    }
}
