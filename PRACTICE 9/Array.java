import java.util.Scanner;

public class Array {
    public static void input(int arr[], Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the arr[" + (i) + "] number: ");
            arr[i] = sc.nextInt();
        }
    }

    public static void output(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swapArr(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static int linear_search(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binary_search(int arr[], int key) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How much you want to store numbers: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        input(arr, sc);

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        int result = binary_search(arr, key);

        if (result != -1) {
            System.out.println("Key is found on index number " + result);
        } else {
            System.err.println("Key is not found.");
        }

        sc.close();
    }
}
