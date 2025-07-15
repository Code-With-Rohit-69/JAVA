import java.util.*;

public class Problem1 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        float num1 = scanner.nextFloat();
        System.out.print("Enter 12nd number: ");
        float num2 = scanner.nextFloat();
        System.out.print("Enter 3rd number: ");
        float num3 = scanner.nextFloat();

        float avg = (num1 + num2 + num3) / 3;

        System.out.println("Average: " + avg);

        scanner.close();

    }
}
