public class Sorting {

    public static void bubble_sort(int arr[]) {
        for (int i = 1; i <= arr.length-1; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selection_sort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            int minValue = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minValue]) {
                    minValue = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValue];
            arr[minValue] = temp;
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 5, 2, 1, 4, 3 };
        // bubble_sort(arr);
        selection_sort(arr);
        printArray(arr);
    }
}