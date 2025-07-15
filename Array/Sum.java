public class Sum {

    // public static int[] twoSum(int[] nums, int target) {
    //     int index[] = new int[2];
    //     int size = nums.length;

    //     for (int i = 0; i * i < size; i++) {
    //         int startIndex = i;
    //         int endingIndex = size-1-i;
    //         System.out.println(startIndex + ", " + endingIndex);

    //         if (nums[startIndex] + nums[endingIndex] == target) {
    //             index[0] = startIndex;
    //             index[1] = endingIndex;
    //         }
    //     }

    //     return index;
    // }

    public static int[] twoSum(int nums[], int target) {

        int newArr[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    newArr[0] = i;
                    newArr[1] = j;
                }
            }
        }

        return newArr;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 11, 15 };
        int newArr[] = twoSum(arr, 9);
        printArr(newArr);

        System.out.println(Integer.MAX_VALUE);
    }
}