import java.util.*;

public class Predecessor_And_Successor {

    static int pre, suc;

    public static void dfs(Node node, int key) {
        if (node == null)
            return;

        if (node.data > pre && key > node.data) {
            pre = node.data;
            dfs(node.right, key);
        } else if (node.data < suc && key < node.data) {
            suc = node.data;
            dfs(node.left, key);
        } else {
            dfs(node.left, key);
            dfs(node.right, key);
        }
    }

    public static ArrayList<Node> findPreSuc(Node root, int key) {

        pre = Integer.MIN_VALUE;
        suc = Integer.MAX_VALUE;

        dfs(root, key);

        if (pre == Integer.MIN_VALUE)
            pre = -1;
        if (suc == Integer.MAX_VALUE)
            suc = -1;

        return new ArrayList<>(Arrays.asList(new Node(pre), new Node(suc)));
    }

    public static int findPredecessor(Node node, int key) {
        int pre = -1;

        while (node != null) {
            if (node.data < key) {
                pre = node.data;
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return pre;
    }

    public static int findSuccessor(Node node, int key) {
        int succ = -1;

        while (node != null) {
            if (node.data > key) {
                succ = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return succ;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int key = 65;

        // ArrayList<Node> res = findPreSuc(root, 65);
        // System.out.println(res.get(0).data + " " + res.get(1).data);

        System.out.println(findPredecessor(root, key) + " " + findSuccessor(root, key));

    }
}

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
