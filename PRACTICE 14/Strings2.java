import java.util.Scanner;

public class Strings2 {

    public static boolean checkPallindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {

            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static float shortestPath(String str) {
        int x1 = 0;
        int y1 = 0;

        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < str.length(); i++) {
            char ith = str.charAt(i);

            if (ith == 'N') {
                y2++;
            } else if (ith == 'S') {
                y2--;
            } else if (ith == 'E') {
                x2++;
            } else if (ith == 'W') {
                x2--;
            } else {
                System.out.println(ith + " is not an valid Path.");
                break;
            }
        }

        float x2minusx1 = x2-x1;
        float y2minusy1 = y2-y1;

        float squareX = (float)Math.pow(x2minusx1, 2);
        float squareY = (float)Math.pow(y2minusy1, 2);

        float result = (float)Math.sqrt(squareX+squareY);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter a String: ");
        // String str = sc.next();

        // boolean result = checkPallindrome(str);

        // if (result) {
        // System.out.println(str + " is an pallindrome String.");
        // } else {
        // System.out.println(str + " is not an pallindrome String.");
        // }

        String path = "WNEENESENNN";

        float result = shortestPath(path);

        System.out.println("Shortest Path is " + result);

        sc.close();
    }
}