import java.util.*;

public class NewPattern {

    public static void invertedNumberPattern(int n) {
        int num = 10;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(num + " ");
                num++ ;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        invertedNumberPattern(rows);
        sc.close();
    }
}
