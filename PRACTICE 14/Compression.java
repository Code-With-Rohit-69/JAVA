import java.util.Scanner;

public class Compression {

    public static String compression(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = 1;

            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++ ;
                i++ ;
            }

            newStr += ch;

            if (count > 1) {
                newStr += count.toString();
            }

        }
        return newStr;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write a String: ");
        String str = sc.next();

        String result = compression(str);
        System.out.println(result);

        sc.close();
    }
}
