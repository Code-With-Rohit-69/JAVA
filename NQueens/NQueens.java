public class NQueens {

    static int count;

    public static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            print(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (check(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean check(char[][] board, int row, int col) {

        // vertical

        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up

        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void print(char[][] board) {
        System.out.println("---------------------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;

        char[][] board = new char[n][n];

        // initialziation

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0);
        System.out.println(count);

    }
}
