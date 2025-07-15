import java.util.*;

public class Problem {

    public static String toUppercase(String str) {
        // StringBuilder newStr = new StringBuilder("");
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            // newStr.append(Character.toUpperCase(str.charAt(i)));
            newStr += Character.toUpperCase(str.charAt(i));
        }

        return newStr.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = toUppercase(str);

        System.out.println(result);

        sc.close();
    }
}
