public class CountSort {

    public static void sort(int arr[]) {
        int maximum = 0;

        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        int freq[] = new int[maximum + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                while (freq[i] > 0) {
                    System.out.print(i + " ");
                    freq[i]--;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 2, 1, 1, 0 };
        sort(arr);
    }
}
