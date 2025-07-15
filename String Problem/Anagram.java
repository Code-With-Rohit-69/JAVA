public class Anagram {

    // public static boolean isAnagram(String s, String t) {
    // for (int i = 0; i < s.length(); i++) {
    // for (int j = 0; j < t.length(); j++) {
    // if (s.charAt(i) != t.charAt(j)) {
    // return false;
    // }
    // }
    // }

    // return true;
    // }

    public static boolean isAnagram(String s, String t) {
        int c = 0;
        char ch = s.charAt(c);

        boolean ans = true;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != ch) {
                ans = false;
            } else{
                ans = true;
            }
            if (i == t.length() - 1) {
                c++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);
        System.out.println(result);

    }
}
