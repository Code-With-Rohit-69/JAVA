import java.util.HashMap;
import java.util.Set;

public class HashMaping {

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();

        // PUT METHOD

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("America", 70);
        hm.put("Nepal", 7);

        Set<String> keys = hm.keySet();

        for (String k : keys) {
            System.out.println("Key: " + k + ", Value: " + hm.get(k));
        }

        // System.out.println(hm);



        // GET METHOD

        // int result = hm.get("India");
        // System.out.println(result);

        // REMOVE METHOD

        // int removingElem = hm.remove("India");
        // System.out.println("Remove Element: " + removingElem);

        // CONTAINS METHOD
        // System.out.println(hm.containsKey("India"));

        // SIZE

        // System.out.println(hm.size());

        // ISEMPTY

        // System.out.println(hm.isEmpty());
        // hm.clear();
        // System.out.println(hm.isEmpty());

    }
}