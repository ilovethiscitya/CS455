/**
 * Created by jianzhe on 2017/11/14.
 */
public class UniquePathii {
    private static int UP(int[][] obstacle) {
        if (obstacle == null || obstacle.length == 0 || obstacle[0].length == 0) {
            return 0;
        }
        int m = obstacle.length;
        int n = obstacle[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacle[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacle[0][i] == 1) break;
            else dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacle[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        int[][] map = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(UP(map));
    }
}
