public class SearchInRotatedArray {

    public static int search(int arr[], int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } 

            if (arr[start] > arr[mid]) {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] < target && target >= arr[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 1, 2, 3, 4 };
        System.out.println(search(arr, 10));
    }
}
