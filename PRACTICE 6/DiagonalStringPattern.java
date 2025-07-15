import java.util.Scanner;

public class DiagonalStringPattern {

    // public static void pattern(String str) {
    // int n = str.length();
    // for (int i = 1; i < str.length(); i++) {
    // for (int j = 1; j < str.length(); j++) {
    // if (i == j) {
    // System.out.print(str.charAt(i - 1) + " ");
    // } else if ((i + j) == n+1) {
    // System.out.print(str.charAt(i - 1) + " ");
    // } else {
    // System.out.print(" ");
    // }
    // }
    // System.out.println();
    // }
    // }

    public static void pattern(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i + j) == n + 1) {
                    System.out.print(str.charAt(i));
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.next();

        pattern(str);

        sc.close();
    }
}
