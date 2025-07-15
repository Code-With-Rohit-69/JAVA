import java.util.Scanner;

public class PairSum2 {
    public static void pairSum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("( " + arr[i] + ", " + arr[j] + " )");
                }
            }
        }
    }

    public static void optimizedPairSum(int arr[], int target) {
        int left = 0;
        int right = arr.length-1;

        while (left != right) {
            if (arr[left] + arr[right] == target) {
                System.out.println("( " + arr[left] + ", " + arr[right] + " )");
                break;
            } else if (arr[left] + arr[right] > target) {
                right-- ;
            } else {
                left++ ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int arr[] = { 1, 2, 3, 4, 5, 6 };
        int arr[] = { 11, 15, 6, 8, 9, 10 };
        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        pairSum(arr, target);
        // optimizedPairSum(arr, target);

        sc.close();
    }
}
