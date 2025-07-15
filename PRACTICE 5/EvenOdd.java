import java.util.Scanner;

public class EvenOdd {
    public static boolean isEvenOdd(int n){
        boolean isEven;

        if (n % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        return isEven;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean result = isEvenOdd(num);
        if (result) {
            System.out.println(num + " is an even number.");
        } else {
            System.out.println(num + " is an odd number.");
        }

        sc.close();
    }
}
