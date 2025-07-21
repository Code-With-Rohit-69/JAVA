import java.util.LinkedList;
import java.util.Queue;

public class KthLevelOfTree {

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

    // DFS

    public static void dfs(Node node, int level, int k) {
        if(node == null) {
            return;
        }

        if(level == k) {
            System.out.print(node.data + " ");
            return;
        }

        dfs(node.left, level+1, k);
        dfs(node.right, level+1, k);
    }

    // BFS

    public static void bfs(Node node, int level, int k) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                
                if(level == k) {
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            level++;
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // dfs(root, 1, 2);
        // bfs(root, 1, 3);

    }
}
