/**
 * Created by jianzhe on 2017/10/19.
 */
public class BestTimetoBuySellStock {
//    private static int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//        int[][] dp = new int[3][prices.length];
//        for (int i = 1; i < dp.length; i++ ) {
//            for (int j = 1; j < dp[0].length;j++) {
//                    int maxValue = 0;
//                    for (int k = 1; k < j; k++) {
//                       maxValue = Math.max(dp[i - 1][k] + prices[j] - prices[k],maxValue);
//                    }
//                    dp[i][j] = Math.max(maxValue,dp[i][j - 1]);
//            }
//        }
//        return dp[2][prices.length - 1];
//    }
    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][prices.length];
        int maxValue = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                maxValue = Math.max(maxValue, prices[j] - prices[i]);
                dp[i][j] = Math.max(maxValue, dp[i - 1][j]);
            }
        }
        return dp[prices.length - 1][prices.length - 1];
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
