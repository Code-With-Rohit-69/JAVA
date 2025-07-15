import java.util.*;

public class Problem3 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price of Pencil: ");
        float num1 = scanner.nextFloat();
        System.out.print("Enter the price of Pen: ");
        float num2 = scanner.nextFloat();
        System.out.print("Enter the price of Eraser: ");
        float num3 = scanner.nextFloat();

        float total = num1 + num2 + num3;

        System.out.println("Total Price: " + total);

        float totalWithGST = (total * 18) / 100;

        System.out.println("Total Price with GST: " + totalWithGST);

        scanner.close();

    }
}
