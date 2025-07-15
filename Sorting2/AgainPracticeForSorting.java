public class AgainPracticeForSorting {

    public static void bubble_sort(int arr[]) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
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
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertion_sort(int arr[]) {

    }

    public static void counting_sort(int arr[]) {
        // int maxValue = Integer.MIN_VALUE;

        // for (int i = 0; i < arr.length; i++) {
        //     maxValue = Math.max(maxValue, arr[i]);
        // }

        // int count[] = new int[maxValue + 1];

        // for (int i = 0; i < arr.length; i++) {
        //     count[arr[i]]++;
        // }

        // int j = 0;
        // for (int i = 0; i < count.length; i++) {
        //     while (count[i] > 0) {
                
        //     }
        // }

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        // bubble_sort(arr);
        // selection_sort(arr);
        insertion_sort(arr);
        print(arr);
    }
}