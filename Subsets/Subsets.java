public class Subsets {

    public static void subsets(String str, String ans, int idx) {

        if (idx == str.length()) {
            if (ans.length() == 0) {
                System.out.print("null" + " ");
            }
            System.out.print(ans + " ");
            return;
        }

        // yes
        subsets(str, ans+str.charAt(idx), idx+1);
        // no
        subsets(str, ans, idx+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        int idx = 0;

        subsets(str, ans, idx);
    }
}