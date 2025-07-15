public class Kadan {

    public static void KadansAlgorithm(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum < 0) {
                currentSum = 0;
            }

            maxValue = Math.max(maxValue, currentSum);
        }

        System.out.println("Our Max sum is : " + maxValue);
    }
    
    public static void main(String []args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        KadansAlgorithm(arr);
    }
}
