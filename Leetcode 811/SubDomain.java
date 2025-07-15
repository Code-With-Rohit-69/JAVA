import java.util.*;

public class SubDomain {

    public static void func(String str[]) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String s : str) {
            String subString[] = s.split(" ");
            
            int count = Integer.parseInt(subString[0]);
            System.out.println("Count: " + count);

            String subDomain[] = subString[1].split("\\.");
            print(subDomain);

            String domain = "";

            for(int i = subDomain.length-1; i >= 0; i--) {
                if(domain.equals("")) {
                    domain += subDomain[i];
                } else {
                    domain = subDomain[i] + "." + domain;
                }

                map.put(domain, map.getOrDefault(domain, 0) + count);
            }

        }

        // listing

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }

        System.out.println(ans);

    }

    public static void print(String arr[]) {
        for (String n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String cpdomains[] = { "9001 discuss.leetcode.com" };
        func(cpdomains);
    }
}