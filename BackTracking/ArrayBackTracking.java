public class ArrayBackTracking {

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int idx, int value) {
        if (idx == arr.length) {
            print(arr);
            return;
        }

        arr[idx] = value;

        changeArray(arr, idx + 1, value + 1);
        arr[idx] = arr[idx] - 2;
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        int idx = 0;
        int value = 1;
        changeArray(arr, idx, value);
        print(arr);
    }
}