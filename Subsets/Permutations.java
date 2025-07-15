public class Permutations {
    
    public static void permutations(String str, String ans) {
        if(str.length() == 0) {
            System.out.print(ans + " ");
            return ;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            // removing
            String Newstr = str.substring(0, i) + str.substring(i+1);

            permutations(Newstr, ans+currChar);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        permutations(str, "");
    }
}
