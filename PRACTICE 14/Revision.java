import java.util.Scanner;

public class Revision {
    public static String subString(String str, int si, int ei) {
        String substr = "";

        for (int i = si; i <= ei; i++) {
            substr += str.charAt(i);
        }

        return substr;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder(" ");

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

    public static String largest(String str[]) {
        String largestString = str[0];
        for (int i = 1; i < str.length; i++) {
            if ((largestString.compareTo(str[i]) < 0)) {
                largestString = str[i];
            }
        }
        return largestString;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fruits[] = {"apple", "banana", "kiwi", "mango", "zinc"};

        System.out.println(largest(fruits));

        // String str = "hi everyone, my self rohit singh. i am from uttarakhand. i am 20 years old.";

        // String result = toUpperCase(str);

        // System.out.println(result);

        // String str = "Hello, World!";

        // System.out.print("Enter starting Index: ");
        // int si = sc.nextInt();

        // System.out.print("Enter Ending Index: ");
        // int ei = sc.nextInt();

        // String result = subString(str, si, ei);

        // System.out.println(result);

        sc.close();
    }
}
