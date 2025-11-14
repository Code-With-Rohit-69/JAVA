public class ContigousSubArrayWithSameCharacter {

    public static void helper(String s, String curr, int index) {
        if (index == s.length()) {
            if (curr.length() > 0 && curr.charAt(0) == curr.charAt(curr.length() - 1)) {
                System.out.print(curr + " ");
            }
            return;
        }

        helper(s, curr + s.charAt(index), index + 1);
        helper(s, curr, index + 1);
    }

    public static void main(String[] args) {
        String s = "abcab";
        helper(s, "", 0);
    }
}