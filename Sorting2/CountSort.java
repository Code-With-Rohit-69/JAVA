public class CountSort {

    public static int[] countSort(int arr[]) {
        // Arrays.sort(arr);
        int resultantArray[] = new int[arr.length];

        int maxValue = 0;

        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }

        int frequency[] = new int[maxValue + 1];

        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] > 0) {
                resultantArray[index] = i;
                frequency[i]--;
                index++ ;
            }
        }

        return resultantArray;
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 4, 3, 1, 5, 1, 7, 1 };
        int result[] = countSort(arr);
        print(result);
    }
}
