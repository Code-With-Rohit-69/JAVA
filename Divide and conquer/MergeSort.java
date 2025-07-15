public class MergeSort {

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void merge_sort(int arr[], int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        // first half
        merge_sort(arr, si, mid);

        // second half
        merge_sort(arr, mid + 1, ei);

        // then merge in a particular order
        merge(arr, si, ei, mid);

    }

    public static void merge(int arr[], int si, int ei, int mid) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[ei - si + 1];

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 5, 2, 7, 3, 8, 0, 1 };
        int si = 0;
        int ei = arr.length - 1;
        merge_sort(arr, si, ei);
        print(arr);
    }
}