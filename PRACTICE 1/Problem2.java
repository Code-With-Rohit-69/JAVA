import java.util.*;

public class Problem2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the side of Square: ");
        float side = scanner.nextFloat();

        float area = side * side;

        System.out.println("Area: " + area);

        scanner.close();

    }
}
