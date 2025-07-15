public class ProductArray {

    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int answer[] = new int[n];

        for (int i = 0; i < answer.length; i++) {
            int ans = 1;
            for (int j = 0; j < answer.length; j++) {
                if (j != i) {
                    ans *= arr[j];
                }
            }

            answer[i] = ans;
        }

        return answer;
    }

    public static int[] optimizedProduct(int arr[]) {
        int n = arr.length;
        int answer[] = new int[n];

        int multiplication = 1;

        for (int i = 0; i < arr.length; i++) {
            multiplication *= arr[i];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = multiplication / arr[i];
        }

        return answer;
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int result[] = optimizedProduct(arr);
        print(result);
    }
}
