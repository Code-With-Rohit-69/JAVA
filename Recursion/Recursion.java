import java.util.Scanner;

public class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);

    }

    public static int natural(int n) {
        if (n == 1) {
            return 1;
        }
        return n + natural(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

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
            System.out.print(n + " ");
            return;
        }
        increasingOrder(n - 1);
        System.out.print(n + " ");
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length-1) {
            return true;
        }

        if (arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int i, int key) {
        if (i == arr.length-1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccur(arr, i+1, key);
    }

    public static int lastOccur(int arr[], int i, int key) {
        if (i == -1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return lastOccur(arr, i-1, key);
    }

    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        }

        return x * power(x, n-1);
    }

    public static int optimizedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n/2);

        int halfPowerSquare = halfPower * halfPower;

        if (n % 2 != 0) {
            halfPowerSquare = halfPowerSquare * a;
        }

        return halfPowerSquare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int result = factorial(n);

        // int result = natural(n);

        // int arr[] = {5, 4, 3, 2, 1};

        // boolean result = isSorted(arr, 0);
        // System.out.println(result);

        // increasingOrder(n);

        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // System.out.println(lastOccur(arr, arr.length-1, 8));
        // System.out.println(firstOccur(arr, 0, 19));

        // System.out.println(power(2, 10));
        System.out.println(optimizedPower(2, 10));
        sc.close();
    }
}
