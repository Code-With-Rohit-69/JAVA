public class Sort {
    public static void bubble_sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selection_sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minNumber = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minNumber] > arr[j]) {
                    minNumber = j;
                }
            }
            int temp = arr[minNumber];
            arr[minNumber] = arr[i];
            arr[i] = temp;
        }
    }

    public static void print_array(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        selection_sort(arr);
        print_array(arr);
    }
}