/**
 * Created by jianzhe on 2017/11/14.
 */
public class sokudoSolver {
    private static void SS(char[][] board) {
        if (board.length == 0 || board == null) return;
        dfsHelper(board,0,0);
    }
    private static boolean dfsHelper(char[][] board,int i, int j) {
        int m = board.length;
        int n = board[0].length;
        while (board[i][j] != '.') {
            j++;
            if (j == n) {
                if (i == m - 1)
                    return true;
                i++;
                j = 0;
            }
            i++;
            }
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] cube = new boolean[9];
        fillChecker(board,i,j,row,col,cube);
        for (int cur = 1; cur <= 9; cur++) {
            board[i][j] = (char)(cur + '0');
            if (!cellChecker(board,i,j,row,col,cube,cur) && dfsHelper(board,i,j)) {
                return true;
            } else {
                board[i][j] = '.';
            }

        }
        return false;
    }
    private static void fillChecker(char[][] board, int curX, int curY, boolean[] row, boolean[] col, boolean[] cube) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[curX][i] != '.') {
                row[board[curX][i] - '1'] = true;
            }
        }
        for (int i = 0; i < board.length;i++) {
            if (board[i][curY] != '.') {
                col[board[i][curY] - '1'] = true;
            }
        }
        int cubeX = curX/3 * 3;
        int cubeY = curY/3 * 3;
        for (int i = cubeX; i < cubeX + 3; i++) {
            for (int j = cubeY; j < cubeY + 3; j++) {
                if (board[i][j] != '.') {
                    cube[board[i][j] - '1'] = true;
                }
            }
        }
    }
    private static boolean cellChecker(char[][] board,int curX, int curY, boolean[] row, boolean[] col, boolean[] cube,int toFill) {
        if (row[toFill - 1] || col[toFill - 1] || cube[toFill - 1]) return false;
        else return true;
    }
}
