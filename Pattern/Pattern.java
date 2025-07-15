import java.util.Scanner;

public class Pattern {
    public static String toUppercase(String str) {
        StringBuilder sb = new StringBuilder("");

        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i <= str.length()-1; i++) {
            if (str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
                i++ ;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    // public static String removeLowerCase(String str) {
    //     StringBuilder sb = new StringBuilder("");

    //     for (int i = 0; i < str.length(); i++) {
    //         if (str.charAt(i) == Character.toUpperCase(str.charAt(i))) {
    //             sb.append(str.charAt(i));
    //         }
    //     }

    //     return sb.toString();
    // }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        String result = toUppercase(str);

        System.out.println(result);

        // System.out.print("Enter a number: ");
        // int n = sc.nextInt();

        // for (int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print(i + "   ");
        //     }
        //     System.out.println();
        // }
        sc.close();
    }
}