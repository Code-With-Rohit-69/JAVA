import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        String result = str.replaceAll("[a-z]", "");

        System.out.println(result);

        sc.close();
    }
}
