import java.util.Arrays;

public class Product {

    public static int[] product(int arr[]) {
        int n = arr.length;
        int answer[] = new int[n];

        int multiplication = 1;

        for (int i = 0; i < n; i++) {
            multiplication *= arr[i];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = multiplication / arr[i];
        }

        return answer;
    }

    public static int[] optimalSolution(int arr[]) {
        int n = arr.length;
        int answer[] = new int[n];

        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * arr[i-1];
        }

        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * arr[i+1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int result[] = optimalSolution(arr); 
        print(result);
    }
}