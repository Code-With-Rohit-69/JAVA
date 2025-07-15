import java.util.Scanner;

public class Problem2 {

    public static String removeLowerCase(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Character.toUpperCase(str.charAt(i))) {
                newStr += str.charAt(i);
            }
        }

        return newStr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String : ");

        String str = sc.nextLine();

        String result = removeLowerCase(str);
        System.out.println(result);

        sc.close();
    }
}
