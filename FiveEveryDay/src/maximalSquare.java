/**
 * Created by jianzhe on 2017/10/13.
 */
public class maximalSquare {
    private static int MS(char[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int row = a.length;
        int col = a[0].length;
        int max = 0;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (dp[i - 1][j - 1] == '1') {
                    dp[i][j] = (Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j],dp[i][j - 1]))) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
