import java.util.Scanner;

/*
        1 2 3 4 5
        1 2 3 4
        1 2 3
        1 2
        1
 */

public class Pattern3 {
    public static void pattern(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        pattern(rows);
        sc.close();
    }
}
