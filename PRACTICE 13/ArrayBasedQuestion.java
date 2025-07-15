import java.util.*;

public class ArrayBasedQuestion {

    public static void getData(int arr[], Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the " + (i+1) + "th number: ");
            arr[i] = sc.nextInt();
        }
    }

    public static void multiply(int arr[], int n) {
        System.out.print("The Array after Multiplication: { ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                continue;
            } else {
                int mul = n*arr[i];
                System.out.print(mul);
                if (arr[i] != arr.length) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("}");
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        getData(arr, sc);

        boolean isNum = false;

        System.out.print("Enter a number from the array you want to multiply: ");
        int num = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                isNum = true;
            }
        }

        if (isNum) {
            multiply(arr, num);
        } else {
            System.out.print(num + " is not present in the given array.");
        }


        sc.close();
    }
}