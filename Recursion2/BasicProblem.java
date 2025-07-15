public class BasicProblem {

    public static void countToN(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        countToN(n - 1);
        System.out.print(n + " ");
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // public static boolean isSorted(int arr[], int index) {
    //     if (index == 0 || index == 1) {
    //         return true;
    //     }

    //     return arr[index - 1] >= arr[index - 2] && isSorted(arr, index - 1);
    // }

    public static int firstOccurence(int arr[], int target, int idx) {

        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == target) {
            return idx;
        }

        return firstOccurence(arr, target, idx + 1);
    }

    public static int lastOccurence(int arr[], int target, int idx) {

        if (idx < 0) {
            return -1;
        }

        if (arr[idx] == target) {
            return idx;
        }

        return lastOccurence(arr, target, idx - 1);

    }

    public static void printAllOccurence(int arr[], int target, int idx) {
        if (idx == arr.length) {
            return;
        }

        if (arr[idx] == target) {
            System.out.print(idx + " ");
        }

        printAllOccurence(arr, target, idx+1);
    }

    public static int power(int a, int n) {

        if (n == 1) {
            return a;
        }

        if (n == 0) {
            return 1;
        }

        return a * power(a, n-1);
    }

    public static int optimizePower(int a, int n) {

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            int halfPower = optimizePower(a, n/2);
            return halfPower * halfPower;
        } else {
            return a * optimizePower(a, n-1);
        }
    }

    public static boolean isSorted(int arr[], int idx) {
        if (idx == arr.length-1) {
            return true;
        }

        if (arr[idx] > arr[idx+1]) {
            return false;
        }

        return isSorted(arr, idx+1);
    }

    public static int fib(int n) {

        if (n == 0 || n ==  1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
    

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}