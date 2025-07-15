public class MatrixDiagonalSum {

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];

            // i+j = n-1 => j = n-i-1

            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int result = diagonalSum(matrix);
        System.out.println(result);

    }
}
