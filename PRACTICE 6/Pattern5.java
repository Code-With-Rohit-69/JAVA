import java.util.Scanner;

public class Pattern5 {

    public static void hollow_rectangle(int totalRows, int totalColumns) {
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                if (i == 1 || i == totalRows || j == 1 || j == totalColumns) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        hollow_rectangle(rows, columns);

        sc.close();
    }
}
