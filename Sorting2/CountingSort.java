public class CountingSort {

    // public static int[] countSort(int arr[]) {
        // int maxValue = 0;
        // int newArr[] = new int[arr.length];

        // for (int i = 0; i < arr.length; i++) {
        //     maxValue = Math.max(maxValue, arr[i]);
        // }

        // int frequency[] = new int[maxValue + 1];

        // for (int i = 0; i < arr.length; i++) {
        //     int elem = arr[i];
        //     frequency[elem]++;
        // }

        // int index = 0;
        // for (int i = 0; i < frequency.length; i++) {
        //     while (frequency[i] > 0) {
        //         newArr[index] = i;
        //         frequency[i]--;
        //         index++;
        //     }
        // }

        // return newArr;
    // }

    public static int[] countSort(int nums[]) {
        int maxValue = 0;
        int arr[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }

        int frequency[] = new int[maxValue + 1];

        for(int i = 0; i < nums.length; i++) {
            int elem = arr[i];
            frequency[elem]++ ;
        }

        int index = 0;

        for(int i = 0; i < frequency.length; i++) {
            while(frequency[i] > 0) {
                arr[index] = i;
                frequency[i]-- ;
                index++ ;
            }
        }

        return arr;
    }

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,2,3,1};
        int result[] = countSort(arr);
        print(result);
    }
}
