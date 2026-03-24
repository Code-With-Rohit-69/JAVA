import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Account_Merge {

    public static void main(String[] args) {
        String[][] accounts = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
                { "John", "johnsmith@mail.com", "john00@mail.com" }, { "Mary", "mary@mail.com" },
                { "John", "johnnybravo@mail.com" } };

        int n = accounts.length;

        HashMap<String, Integer> map = new HashMap<>();
        Disjoint dis = new Disjoint(n);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts[i].length; j++) {
                String s = accounts[i][j];

                if (!map.containsKey(s)) {
                    map.put(s, i);
                } else {
                    dis.union(i, map.get(s));
                }
            }
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> mergedMap = new HashMap<>();

        for (String email : map.keySet()) {
            int parent = dis.findParent(map.get(email));

            if (!mergedMap.containsKey(parent)) {
                mergedMap.put(parent, new ArrayList<>());
            }

            mergedMap.get(parent).add(email);
        }

        for(ArrayList<String> list : mergedMap.values()) {
            Collections.sort(list);
        }

        for (int parent : mergedMap.keySet()) {
            List<String> temp = new ArrayList<>();

            temp.add(accounts[parent][0]);
            temp.addAll(mergedMap.get(parent));

            ans.add(new ArrayList<>(temp));
        }

        System.out.println(ans);

    }
}

class Disjoint {
    int[] parent;
    int[] rank;

    public Disjoint(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public void union(int a, int b) {
        int parentA = findParent(a), parentB = findParent(b);

        if (parentA == parentB) {
            return;
        }

        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }
}