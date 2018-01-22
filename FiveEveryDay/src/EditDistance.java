/**
 * Created by jianzhe on 2017/10/15.
 */
public class EditDistance {
    private static int ED(String s1,String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length();i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= s2.length();i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length();i++) {
            for (int j = 1; j <= s2.length();j++) {
                if (s1.charAt(i- 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],Math.min(dp[i][j - 1],dp[i - 1][j]));
                }
            }
        }
        for (int i = 0; i < dp.length;i++) {
            for (int j = 0; j < dp[0].length;j++) {
                System.out.print(dp[i][j]);
                if (j == dp[0].length - 1){
                    System.out.println(",");
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "azced";
        System.out.println(ED(s1,s2));
    }
}
