public class MaxSubArray {

    public static void maxSubArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("[ ");
                for (int k = i; k <= j; k++) {
                    int sum = 0;
                    System.out.print(arr[k]);
                    // if () {
                    //     System.out.print(", ");
                    // }
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, -2, 6, -1, 3};
        maxSubArray(arr);
    }
}
