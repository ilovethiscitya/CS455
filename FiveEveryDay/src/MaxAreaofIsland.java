import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianzhe on 2017/10/7.
 */
public class MaxAreaofIsland {
    public static int max = 0;
    private static int maxIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] count = {1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    dfsHelper(grid,row,col,i,j,count);
                    max = Math.max(max,count[0]);
                    count[0] = 1;
                }
            }
        }
        return max;
    }
    private static void dfsHelper(int[][] grid, int row, int col ,int x, int y,int[] count) {
        grid[x][y] = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isValid(i,j,x,y,row,col) && grid[x + i][y + j] == 1) {
                    count[0]++;
                    dfsHelper(grid,row,col,x + i, y + j,count);
                }
            }
        }
    }
    private static boolean isValid(int di, int dj, int i, int j, int row, int col) {
        return Math.abs(di) != Math.abs(dj) && i + di >=0 && i + di < row && j + dj >=0 && j + dj < col;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}

        };
        System.out.println(maxIsland(grid));
    }
}
