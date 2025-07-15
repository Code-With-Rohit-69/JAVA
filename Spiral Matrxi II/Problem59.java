public class Problem59 {

    public static int[][] generateMatrix(int n) {
        int startRow = 0;
        int endRow = n-1;
        int startColumn = 0;
        int endColumn = n-1;

        int matrix[][] = new int[n][n];
        int elem = 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // TOP
            for (int i = startColumn; i <= endColumn; i++) {
                matrix[startRow][i] = elem++;
                // elem++ ;
            }

            // right

            for (int i = startRow+1; i <= endRow; i++) {
                matrix[i][endColumn] = elem++;
                // elem++;
            }

            // bottom

            if (startRow < endRow) {
                for (int i = endColumn-1; i >= startColumn; i--) {
                    matrix[endRow][i] = elem++;
                    // elem++ ;
                }
            }

            // left

            if (startColumn < endColumn) {
                for (int i = endRow-1; i >= startRow+1; i--) {
                    matrix[i][startColumn] = elem++;
                    // elem++ ;
                }
            }

            startRow++ ;
            endRow--;
            startColumn++ ;
            endColumn-- ;


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
        int n = 3;
        int result[][] = generateMatrix(n);
        print(result);

    }
}