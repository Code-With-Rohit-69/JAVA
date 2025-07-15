public class ArrayMaxSumPart2 {

    public static int MaxSum(int arr[]){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                System.out.print("[ ");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                    if (k < j) {
                        System.out.print(", ");
                    }
                    sum += arr[k];
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                }
                System.out.print(" ] sum = " + sum + " ");
            }
            System.out.println();
        }
        
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {1, -2, 6, -1, 3};
        int result = MaxSum(arr);
        System.out.println("\nMaximum sum is: " + result);
    }
}
