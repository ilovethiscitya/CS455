/**
 * Created by jianzhe on 2017/10/14.
 */
public class BuyStock {
    private static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
            return 0;
        }
        int[][] T = new int[k + 1][prices.length];
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for(int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal,prices[j] - prices[m] + T[i - 1][m] );
                }
                T[i][j] = Math.max(maxVal,T[i][j - 1]);
            }
        }
        return T[k][prices.length - 1];
    }
}
