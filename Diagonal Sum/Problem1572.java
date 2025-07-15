public class Problem1572 {

    public static int diagonalSum(int arr[][]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                } else if ((i+j) == arr.length-1) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    public static int optimizeDiagonalSum(int arr[][]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];

            if (i != arr.length-i-1) {
                sum += arr[i][arr.length-i-1];
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int result = optimizeDiagonalSum(arr);
        System.out.println(result);
    }
}