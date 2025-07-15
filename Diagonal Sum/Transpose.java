public class Transpose {

    public static int[][] transpose(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;

        int transposeMatrix[][] = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
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
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        System.out.println("Original Matrix: ");
        print(matrix);

        int result[][] = transpose(matrix);

        System.out.println("After Transposing Array: ");
        print(result);
    }
}
