import java.util.*;

/**
 * Created by jianzhe on 2017/10/8.
 */
public class NumberofDistinctIslands {
    private static int numDistinctISlands(int[][] grid) {
        HashSet<String> hashSet = new HashSet<>();
        String res = new String();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res= bfsHelper(grid,row,col,i,j);
                    System.out.println(res);
                    hashSet.add(res);
                }
            }
        }
        return hashSet.size();
    }
    private static String bfsHelper(int[][] grid, int row,int col, int x, int y) {
        grid[x][y] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x * col + y);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curX = cur/col;
            int curY = cur%col;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (isValid(i, j,curX, curY, row, col) && grid[curX + i][curY + j] == 1) {
                        q.offer((curX + i)* col + curY + j);
                        grid[curX + i][curY + j] = 0;
                        sb.append(i);
                        sb.append(j);
                    }
                }
            }
        }
        return sb.toString();
    }
    private static boolean isValid(int di, int dj, int x, int y, int row, int col) {
        return Math.abs(di) != Math.abs(dj) && x + di >= 0 && x + di < row && y + dj >= 0 && y + dj < col;
    }


    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(numDistinctISlands(grid));
        System.out.println();
    }
}

