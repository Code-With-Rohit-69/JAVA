import java.util.Scanner;

public class Problem {

    public static void pattern(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == j || (i+j) == str.length()+1) {
                    System.out.print(str.charAt(i) + " ");
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
        String str = sc.nextLine();

        pattern(str);

        sc.close();
    }
}