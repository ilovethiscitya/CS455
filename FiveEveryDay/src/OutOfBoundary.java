/**
 * Created by jianzhe on 2017/11/5.
 */
public class OutOfBoundary {
    private static int OB(int m, int n, int N, int i0, int j0) {
        long limit = 1000000007;
        long[][][] dp = new long[N + 1][m + 1][n + 1];
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[k][i][j] += i == 0 ? 1 : dp[k - 1][i - 1][j];
                    dp[k][i][j] += i == m - 1 ? 1 : dp[k - 1][i + 1][j];
                    dp[k][i][j] += j == 0 ? 1 : dp[k - 1][i][j - 1];
                    dp[k][i][j] += j == n - 1 ? 1 : dp[k - 1][i][j - 1];
                    dp[k][i][j] %= limit;
                }
            }
        }
        return (int)dp[N][i0][j0];
    }
}
