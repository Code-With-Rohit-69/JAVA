import java.util.*;

public class Strings3 {

    public static String subString(String str, int startingIndex, int endingIndex) {
        String subStr = "";
        for (int i = startingIndex; i < endingIndex; i++) {
            subStr += str.charAt(i);
        }
        return subStr;
    }

    public static String largest(String str[]) {
        String largestLexicode = str[0];

        for (int i = 1; i < str.length; i++) {
            if ((largestLexicode.compareTo(str[i])) < 0) {
                largestLexicode = str[i];
            }
        }

        return largestLexicode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fruits[] = {"apple", "banana", "mango"};

        String result = largest(fruits);
        System.out.println(result);

        // String str = "Hello, World!";

        // System.out.print("Enter the starting Index: ");
        // int startingIndex = sc.nextInt();

        // System.out.print("Enter the Ending Index: ");
        // int endingIndex = sc.nextInt();

        // String result = subString(str, startingIndex, endingIndex);
        // System.out.println(result);

        sc.close();

        // System.out.println(str.substring(0, 4));
    }
}
