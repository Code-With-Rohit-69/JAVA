import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String words[] = { "baa", "abcd", "abca", "cab", "cad" };

        int k = 26;
        int[] indegree = new int[k];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int min = Math.min(s1.length(), s2.length());
            boolean isFound = false;

            for (int j = 0; j < min; j++) {
                int u = s1.charAt(j) - 'a', v = s2.charAt(j) - 'a';

                if (s1.charAt(j) != s2.charAt(j)) {
                    graph.get(u).add(v);
                    indegree[v]++;
                    isFound = true;
                    break;
                }

            }
            if (!isFound && s2.length() < s1.length()) {
                System.out.println("");
                return;
            }
        }

        boolean[] present = new boolean[k];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0 && present[i]) {
                q.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.append((char) (curr + 'a'));

            for (int num : graph.get(curr)) {
                indegree[num]--;
                if (indegree[num] == 0) {
                    q.add(num);
                }
            }
        }

        System.out.println(ans.toString());

    }
}