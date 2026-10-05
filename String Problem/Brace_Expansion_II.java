import java.io.*;
import java.util.*;

public class Brace_Expansion_II {

    static TreeSet<String> set;

    public static void dfs(String s) {
        if(s.length() == 0) {
            return;
        }

        int close = s.indexOf('}');
        if(close == -1) {
            set.add(s);
            return;
        }

        int open = s.lastIndexOf('{', close);

        String[] parts = s.substring(open + 1, close).split(",");

        for(String part : parts) {
            dfs(s.substring(0, open) + part + s.substring(close + 1));
        }
    }
    
    public static void main(String[] args) throws IOException {
        // String s = "{a,b}{c,{d,e}}";
        String s = "a{b,c}{d,e}f{g,h}";

        set = new TreeSet<>();

        dfs(s);

        System.out.println(set);

    }
}