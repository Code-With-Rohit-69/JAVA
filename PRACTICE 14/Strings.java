import java.util.*;

// Strings are immutable - which cannot be changed after initializtion

public class Strings {

    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

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
                y2 += 1;
            } else if (ith == 'S') {
                y2 -= 1;
            } else if (ith == 'W') {
                x2 -= 1;
            } else if (ith == 'E') {
                x2 += 1;
            } else {
                System.out.println("Your co-ordinates are not correct.");
                break;
            }
        }

        int x2Minusx1 = x2-x1;
        int y2Minusy1 = y2-y1;

        int squareX = (int)Math.pow(x2Minusx1, 2);
        int squareY = (int)Math.pow(y2Minusy1, 2);

        int response = squareX + squareY;

        float result = (float)Math.sqrt(response);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz");

        // System.out.print("Enter the Name: ");
        // String name;

        // name = sc.nextLine();
        // System.out.println(name);

        // String fullName = "Rohit Singh";

        // System.out.println(fullName.length());

        // String firstName = "Rohit";
        // String lastName = "Singh";

        // String fullName = firstName + " " + lastName;

        // System.out.println(firstName.concat(lastName));

        // System.out.println(fullName.charAt(5));

        // printLetters(fullName);

        // System.out.print("Enter the String: ");
        // String str = sc.next();

        // boolean result = checkPallindrome(str);

        // if (result) {
        // System.out.print(str + " is an Pallindrome String.");
        // } else {
        // System.out.println(str + " is not an pallindrome String.");
        // }

        // String path = "WNEENESENNN";

        // float res = shortestPath(path);

        // System.out.println("Shortest Path: " + res);

        

        sc.close();
    }
}