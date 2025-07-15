public class Problem852 {

    public static int peakIndexInMountainArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid ;
            } else if (arr[mid] > arr[mid - 1]) {
                start = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 5, 4, 4 };
        int arr[] = { 3, 5, 3, 2, 0 };
        // int arr[] = {0, 1, 0};
        // int arr[] = { 18, 29, 38, 59, 98, 100, 99, 98, 90 };
        int result = peakIndexInMountainArray(arr);
        System.out.println(result);
    }
}