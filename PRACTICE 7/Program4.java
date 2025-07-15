
public class Program4 {
    public static void LinearSearch(int num[], int key) {
        boolean isFound = false;
        int index = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                isFound = true;
                index = i;
                break;
            }
        }
        if (isFound) {
            System.out.println(key + " is present on index number " + index);
        } else {
            System.out.println(key + " is not present.");
        }
    }

    public static void print(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }

    public static void Largest(int num[]) {
        // int bigger = Integer.MIN_VALUE;
        int smaller = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < smaller) {
                smaller = num[i];
            }
        }
        System.out.println("Smaller is: " + smaller);
    }

    public static int BinarySearch(int num[], int key) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] == key) {
                return mid;
            } else if (num[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void Reverse(int num[]) {
        int start = 0;
        int end = num.length - 1;

        while (start < end) {
            int temp = num[end];
            num[end] = num[start];
            num[start] = temp;
            start++;
            end--;
        }
    }

    public static void Pair(int arr[]) {
        int totalPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ")");
                totalPairs++;
                if (j < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("Total Pairs = " + totalPairs);
    }

    public static int printSum(int arr[], int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static void SubArrays(int arr[]) {
        int totalSubArrays = 0;
        int subArraySum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                    if (k < j) {
                        System.out.print(", ");
                    }
                }
                subArraySum = printSum(arr, i, j);
                System.out.print("] Sum = " + subArraySum);
                totalSubArrays++;
                if (j < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            
            System.out.println();
        }
        System.out.println("Total SubArrays = " + totalSubArrays);
    }

    public static void main(String[] args) {
        int num[] = { 2, 4, 6, 8, 10 };
        SubArrays(num);
    }
}
