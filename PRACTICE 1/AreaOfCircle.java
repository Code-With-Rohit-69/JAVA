import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Radius of Circle: ");
        float radius = scanner.nextFloat();
        float area = 3.14f * radius * radius;

        System.out.println("Area is: " + area);

        scanner.close();
    }
}
