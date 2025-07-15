public class Subsets2 {
    
    public static void subsets(String str, int idx, String ans) {

        // BASE CASE
        if (idx == str.length()) {
            if (ans.length() == 0) {
                System.out.print("null" + " ");
            }
            System.out.print(ans + " ");
            return;
        }

        // I HAVE TWO CHOICES WHETHER TO PICK YES OR NO
        // IF I PICK YES THEN

        subsets(str, idx+1, ans+str.charAt(idx));

        // IF I PICK NO, THEN

        subsets(str, idx+1, ans);


    }
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        int idx = 0;
        subsets(str, idx, ans);
    }
}
