import java.util.Scanner;

public class SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int startRow = 0;
        int startColumn = 0;
        int endRow = n - 1;
        int endColumn = n - 1;

        int elem = 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // top row

            for (int i = startColumn; i <= endColumn; i++) {
                matrix[startRow][i] = elem++;
            }

            // right column

            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endColumn] = elem++;
            }

            // bottom row

            if (startRow < endRow) {
                for (int i = endColumn - 1; i >= startColumn; i--) {
                    matrix[endRow][i] = elem++;
                }
            }

            // left column

            if (startColumn < endColumn) {
                for (int i = endRow - 1; i >= startRow + 1; i--) {
                    matrix[i][startColumn] = elem++;
                }
            }

            startRow++;
            startColumn++;
            endRow--;
            endColumn--;

        }

        return matrix;
    }

    public static void print(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result[][] = generateMatrix(n);
        print(result);

        sc.close();
    }
}
