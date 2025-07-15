public class Captilize {

    public static String capitalizeTitle(String str) {
        StringBuilder sb = new StringBuilder();

        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
                i++ ;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String title = "First leTTeR of EACH Word";
        System.out.println(capitalizeTitle(title));
    }
}
