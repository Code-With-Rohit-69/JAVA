public class ReverseWordInString {
    
    public static String reverse(String s) {
        String str[] = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length-1; i >= 0; i--) {
            sb.append(str[i] + " ");
        }

        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String s = "a good   example";
        String result = reverse(s);
        System.out.println(result);
    }
}
