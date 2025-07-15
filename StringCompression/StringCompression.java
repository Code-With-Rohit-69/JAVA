import java.lang.String;

public class StringCompression {

    public static int stringCompression(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            int count = 1;

            while (i < str.length() - 1 && str.charAt(i + 1) == currChar) {
                count++;
                i++;
            }

            newStr += currChar;

            if (count > 1) {
                newStr += count;
            }
        }

        char output[] = newStr.toCharArray();

        return output.length;

    }

    public static int compress(char[] chars) {
        String str = String.valueOf(chars);
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char currChar = str.charAt(i);

            while (i < str.length() - 1 && str.charAt(i + 1) == currChar) {
                count++;
                i++;
            }

            newStr += currChar;

            if (count > 1) {
                newStr += count;
            }

        }

        System.out.println(newStr);

        char charArray[] = newStr.toCharArray();
        System.out.println(charArray);

        return charArray.length;

    }

    public static void main(String[] args) {
        char chars[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

        System.out.println(compress(chars));
    }
}