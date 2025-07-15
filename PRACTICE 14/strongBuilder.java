public class strongBuilder {

    public static void character() {
        StringBuilder sb = new StringBuilder(" ");

        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(i);
        }

        System.out.println(sb);
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("  ");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(' ');
                i++ ;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // String str = "hi, my self rohit singh thakur. i am from dineshpur, udham singh nagar, uttarakhand";

        // System.out.println(toUpperCase(str));
        character();
    }
}
