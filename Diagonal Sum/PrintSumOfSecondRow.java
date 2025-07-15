public class PrintSumOfSecondRow {

    public static int printSum(int arr[][]) {
        int sum = 0;
        int col = arr[0].length;

        for (int i = 0; i < col; i++) {
            sum += arr[1][i];
        }


        return sum;
    }
    
    public static void main(String[] args) {
        int arr[][] = {
            {1, 2, 3},
            {11, 4, 3},
            {7, 8, 9}
        };

        System.out.println(printSum(arr));
    }
}
