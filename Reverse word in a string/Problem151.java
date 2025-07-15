public class Problem151 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            StringBuilder word = new StringBuilder();

            while (i < sb.length() && sb.charAt(i) != ' ') {
                word.append(sb.charAt(i));
                i++;
            }

            if (word.length() > 1) {
                ans.append(" " + word.reverse());
            }
        }

        return ans.toString().trim();
    }

    public static String optimizedRevString(String str) {
        StringBuilder ans = new StringBuilder();
        String words[] = str.split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if (i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        String str = "  hello world  ";
        String result = optimizedRevString(str);
        System.out.println(result);
    }
}