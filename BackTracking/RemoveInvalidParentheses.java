import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {

    static int n;
    static HashSet<String> set;
    
    public static  void dfs(int index, String s, StringBuilder sb, int open , int close) {
        // System.out.println("index: " + index + " string: " + sb);
        
        if(index >= n) {
            
            // System.out.println("close: " + close + " open: " + open);
            
            if(open == close) {
                set.add(sb.toString());
            }
            
            return;
        }
        
        char ch = s.charAt(index);
        
        if(Character.isLetter(ch)) {
            sb.append(ch);
            dfs(index + 1, s, sb, open, close);
            sb.deleteCharAt(sb.length() - 1);
            return;
        } 
        
        if(ch == '(') {
            sb.append(ch);
            dfs(index + 1, s, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
            
            dfs(index + 1, s, sb, open, close);
        } else {
            
            if(open > close) {
                sb.append(ch);
                dfs(index + 1, s, sb, open, close + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            
            dfs(index + 1, s, sb, open, close);
        }
        
    }

    public static void main(String[] args) {
        // String s = "q)(ug)";
        String s = "()(l()((";

        n = s.length();
        
        set = new HashSet<>();
        
        dfs(0, s, new StringBuilder(), 0, 0);
        
        if(set.size() == 0) {
            System.out.println("EMPTY");
            return;
        }
        
        int size = 0;
        
        for(String str : set) {
            size = Math.max(size, str.length());
        }
        
        List<String> res = new ArrayList<>();
        
        for(String str : set) {
            if(str.length() == size) {
                res.add(str);
            }
        }
        
        Collections.sort(res);

        System.out.println(res);
        
    }
}