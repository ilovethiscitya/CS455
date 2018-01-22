/**
 * Created by jianzhe on 2017/10/7.
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 the characters without
 disturbing the relative positions of he remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 *
 */
public class Distinct_Subsequence {
    private static int DS(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return 0;
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String S = "acdabefbc";
        String T = "ab";
        System.out.println(DS(S,T));
    }


}
