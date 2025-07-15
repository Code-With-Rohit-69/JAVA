import java.util.ArrayList;

public class Practice2 {

    public static void subset(String str, int idx, String ans) {

        if(idx == str.length()) {
            if(ans.length() == 0) {
                System.out.print("null" + " ");
            }
            System.out.print(ans + " ");

            return;
        }

        // yes

        subset(str, idx+1, ans+str.charAt(idx));

        // no

        subset(str, idx+1, ans);
    }
    
    public static void main(String[] args) {
        String string = "abc";
        subset(string, 0, "");
    }
}
