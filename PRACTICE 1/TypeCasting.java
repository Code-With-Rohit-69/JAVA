import java.util.Scanner;

public class TypeCasting {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        byte a = 5;
        byte b = (byte) (a * 2);

        System.out.println(b);

        scanner.close();
    }
}
