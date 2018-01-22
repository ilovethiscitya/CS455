/**
 * Created by jianzhe on 2017/10/4.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[][] minLen = new int[row][col];
        return helper(grid,0,0,minLen);
    }
    private static int helper(int[][] grid, int row, int col, int[][] minLen) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        if (minLen[row][col] != 0) {
            return minLen[row][col];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (row < grid.length - 1) {
            down = helper(grid,row + 1, col, minLen);
        }
        if (col < grid[0].length- 1) {
            right = helper(grid,row,col + 1, minLen);
        }
        minLen[row][col] = Math.min(down,right) + grid[row][col];
        return minLen[row][col];
    }
}
