import java.util.Scanner;

public class BasicProblem {

    public static void Occurences(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.print(i + " ");
            }
        }
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        System.out.print("Enter a Key: ");
        int key = sc.nextInt();

        Occurences(arr, key);

        sc.close();
    }
}