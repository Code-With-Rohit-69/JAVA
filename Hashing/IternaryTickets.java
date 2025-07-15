import java.util.*;

public class IternaryTickets {
    public static void main(String[] args) {
        String from[] = { "Chennai", "Mumbai", "Goa", "Delhi" };
        String to[] = { "Bengaluru", "Delhi", "Chennai", "Goa" };

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        int n = from.length;
        String starts = "";

        for (int i = 0; i < n; i++) {
            map2.put(to[i], from[i]);
        }

        for (int i = 0; i < n; i++) {
            if (map2.containsKey(from[i])) {
                starts = from[i];
            }
            map1.put(from[i], to[i]);
        }

    }
}
