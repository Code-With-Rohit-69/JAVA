import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {

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

    // static HashMap<Integer, Integer> map = new HashMap<>();

    // public static void backtrack(Node root, int level) {
    //     if(root == null) {
    //         return;
    //     }

    //     if(!map.containsKey(level)) {
    //         map.put(level, root.data);
    //     }

    //     backtrack(root.left, level - 1);
    //     backtrack(root.right, level + 1);
    // }


    static class Pair {
        Node node;
        int dis;

        public Pair(Node node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public static void helper(Node node) {
        if(node == null) {
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        int min = 0, max = 0;

        q.offer(new Pair(node, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if(!map.containsKey(curr.dis)) {
                min = Math.min(min, curr.dis);
                max = Math.max(max, curr.dis);
                map.put(curr.dis, curr.node.data);
            }

            if(curr.node.left != null) {
                q.offer(new Pair(curr.node.left, curr.dis - 1));
            }

            if(curr.node.right != null) {
                q.offer(new Pair(curr.node.right, curr.dis + 1));
            }
        }

        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)) {
                System.out.print(map.get(i) + " ");
            }
        }

    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        helper(root);

    }
}
