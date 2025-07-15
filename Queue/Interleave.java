public class Interleave {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;

        int result[] = new int[n];
        int idx = 0;

        for(int i = 0; i < n; i += 2) {
            result[i] = arr[idx++];
        }

        for(int i = 1; i < n; i += 2) {
            result[i] = arr[idx++];
        }

        for(int num : result) {
            System.out.print(num + " ");
        }

    }
}
