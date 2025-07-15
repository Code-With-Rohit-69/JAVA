import java.util.Scanner;

public class RecursionRevision {
    public static void decreasingOrder(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        decreasingOrder(n - 1);
    }

    public static void increasingOrder(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }

        increasingOrder(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }

        return n * factorial(n - 1);
    }

    public static int natural(int n) {
        if (n == 1) {
            return 1;
        }

        return n + natural(n - 1);
    }

    public static int firstOccur(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }

        return firstOccur(arr, key, i + 1);
    }

    public static int lastOccur(int arr[], int key, int i) {
        if (i == -1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return lastOccur(arr, key, i - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 2, 3, 4, 5, 4, 1, 9 };
        int key = 9;
        int i = arr.length - 1;

        int result = firstOccur(arr, key, i);
        System.out.println(result);

        sc.close();
    }
}