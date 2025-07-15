public class Permutations {

    public static void permute(String str, String ans) {

        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permute(newStr, ans + currChar);
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";

        permute(str, ans);
    }
}
