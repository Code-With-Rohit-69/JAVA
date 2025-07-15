import java.util.Scanner;

public class Program3 {

    public static void update(int marks[]){
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void print(int marks[]){
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int marks[] = {86, 87, 88};
        update(marks);
        print(marks);

        sc.close();
    }
}
