public class Search2D {

    public static int[] search(int arr[][], int target) {
        int row = arr.length;
        int column = arr[0].length;

        int i = 0;
        int j = column-1;

        while (i < row && j >= 0) {
            if (arr[i][j] == target) {
                return new int[] {i, j};
            } else if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] {-1, -1};
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int arr[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int result[] = search(arr, 10);
        print(result);
    }
}
