public class BinarySearch {

    public static int search(int arr[], int si, int ei, int target) {

        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search(arr, si, mid-1, target);
        } else {
            return search(arr, mid+1, ei, target);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 6, 7 };
        int target = 70;
        int result = search(arr, 0, arr.length - 1, target);
        System.out.println(result);
    }
}
