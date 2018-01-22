/**
 * Created by jianzhe on 2017/11/12.
 */
public class ValidSudoku {
    private static boolean isValid(char[][] board) {
        int n = board.length;
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] block = new boolean[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int cur = board[i][j] - '0';
                if (row[i][cur - 1] || col[j][cur - 1] || block[(i / 3) * 3 + j / 3][cur - 1] )
                    return false;
                row[i][cur - 1] = true;
                col[j][cur - 1] = true;
                block[(i / 3) * 3 + j / 3][cur - 1] = true;
            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValid(board));
    }


}
