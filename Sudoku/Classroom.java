public class Classroom {

    public static boolean isSafe(char[][] board, int row, int col, char digit) {
        // row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // grid

        int stRow = (row / 3) * 3;
        int stCol = (col / 3) * 3;

        for (int i = stRow; i < stRow + 3; i++) {
            for (int j = stCol; j < stCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean helper(char[][] board, int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;

        if (nextCol == 9) {
            nextCol = 0;
            nextRow += 1;
        }

        if (board[row][col] != '.')
            return helper(board, nextRow, nextCol);

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;
                if (helper(board, nextRow, nextCol))
                    return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    public static void print(char[][] ch) {
        for (char[] c : ch) {
            for (char a : c) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },

                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },

                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        boolean result = helper(board, 0, 0);

        if (result) {
            System.out.println("Solution exists!");
            print(board);
        } else {
            System.out.println("Solution doesn't exists!");
        }

    }
}