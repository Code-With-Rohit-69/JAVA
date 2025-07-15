public class PeakIndexOfMountain {

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid ;
            }   

        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 10, 6, 5, 3, 1 };

        int result = peakIndexInMountainArray(arr);
        System.out.println(result);
    }
}
